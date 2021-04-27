package cn.com.jinkang.module.standard.controller.userController;

import cn.com.jinkang.module.standard.common.exception.BizException;
import cn.com.jinkang.module.standard.pojo.dto.person.CertifiedPersonnel;
import cn.com.jinkang.module.standard.pojo.dto.user.UserInfo;
import cn.com.jinkang.module.standard.service.personservice.PersonService;
import cn.com.jinkang.module.standard.service.userservice.MyUserDetailsService;
import cn.com.jinkang.module.standard.util.redisutil.JwtUtil;
import cn.com.jinkang.module.standard.util.redisutil.RedisUtils;
import cn.com.jinkang.module.standard.util.sendmesutil.SendSMSUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Api(value = "用户相关接口")
@RequestMapping("/index")
@RestController
public class UserController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    PersonService personService;

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @ApiOperation(value = "登陆")
    @PostMapping("login")
    public Map<String,Object> login(@RequestParam String username, @RequestParam String password) throws Exception {
        Map<String, Object> map = new HashMap<>();
        if(myUserDetailsService.loadUserByUsername(username)==null) {
            throw new BizException("账号不存在");
        }
        UserInfo userInfo=myUserDetailsService.selectOne(username,password);
        if(userInfo==null){
            throw new BizException("账号或密码错误");
        }
        CertifiedPersonnel personnel=personService.selectOne(username);
        String token = JwtUtil.creat(personnel.getName());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("token", token);
        redisUtils.set(personnel.getName(), token);
        redisUtils.expire(personnel.getName(), 60*10);
        map.put("token",token);
        map.put("user",personnel);
        map.put("role",userInfo.getRole());
        return map;
    }
    @PostMapping("/refreshToken")
    @ResponseBody
    @ApiOperation(value = "刷新token")
    public Map<String, Object> refreshToken(@RequestBody String token) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isEmpty(token)) {
            map.put("message", "token已过期");
            return map;
        } else {
            String userName = JwtUtil.getUserNameByToken(token);
            if (token.equals(redisUtils.get(userName))) {
                String newToken = JwtUtil.creat(userName);
                redisUtils.getAndSet(userName, newToken);
                redisUtils.expire(userName, 60*10);
                map.put("token", newToken);
                map.put("failureDate", df.format(JwtUtil.getExpiresDate(newToken)));
                return map;
            } else {
                map.put("message", "token失效或过期");
                return map;
            }
        }

    }

    /**
     * @Description:发送手机验证码
     * @Param:手机号码
     * @return:1表示成功，0表示失败
     */
    @PostMapping("loginPhone")
    @ResponseBody
    @ApiOperation(value = "短信登陆")
    public boolean loginPhone(String phoneNumber) {
        CertifiedPersonnel personnel=personService.selectPersonPhone(phoneNumber);
        if(personnel==null){
            throw new BizException("用户不存在");
        }
        // 发送短信
        SendSMSUtil sendSMS = new SendSMSUtil();
        // 获取验证码
        String code=String.valueOf(sendSMS.sendMes(phoneNumber));

        redisUtils.set("code", code);
        redisUtils.expire(code, 60*5);
        redisUtils.set("phone",phoneNumber);
        redisUtils.expire("phone",60*5);
        return true;

    }
    /**
     * @Description:校验验证码是否正确
     * @Param:验证码
     * @return:成功返回OK，验证码超时返回TimeOut，验证码错误返回CodeError
     */
    @PostMapping("checkCode")
    @ResponseBody
    @ApiOperation(value = "验证码验证")
    public Map<String,Object> checkCode(String checkSMSCode, HttpServletRequest request) {
        Map<String,Object>result=new HashMap<>();
        CertifiedPersonnel personnel=personService.selectPersonPhone(redisUtils.get("phone"));
        String token = JwtUtil.creat(personnel.getName());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("token", token);
        redisUtils.set(personnel.getName(), token);
        redisUtils.expire(personnel.getName(), 60*10);
        result.put("token",token);
        result.put("user",personnel);
        String serverCheckCode=redisUtils.get("code");
       if(serverCheckCode.equals("")||serverCheckCode==null){
           throw new BizException("验证码失效");
       }
       if(!serverCheckCode.equals(checkSMSCode)){
           throw new BizException("验证码错误");
       }

        return result;
    }
    @PostMapping("cancellation")
    @ResponseBody
    @ApiOperation(value = "注销")
    public boolean cancellation(String username){
        return redisUtils.delete(username);
    }



}
