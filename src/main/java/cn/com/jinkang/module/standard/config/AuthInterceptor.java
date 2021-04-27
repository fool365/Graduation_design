package cn.com.jinkang.module.standard.config;

import cn.com.jinkang.module.standard.common.exception.BizException;
import cn.com.jinkang.module.standard.util.redisutil.JwtUtil;
import cn.com.jinkang.module.standard.util.redisutil.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    RedisUtils redisUtils;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws BizException, IOException {
        if (request.getHeader(HttpHeaders.ORIGIN) != null & HttpMethod.OPTIONS.matches(request.getMethod())) {
            return true;
        }
        response.setCharacterEncoding("UTF-8");

        String token = request.getHeader("token");
        if(token==null){
            throw  new BizException("无token值");
        }
        String userName = JwtUtil.getUserNameByToken(token);

        if (StringUtils.isEmpty(token)) {
            throw  new BizException("用户未登录，请登录后操作！");
        }
        if(StringUtils.isEmpty(redisUtils.get(userName))) {
            throw  new BizException("token已过期，请重新登陆！");
        }
        if(JwtUtil.isExpiration(token)) {   //token未过期，判断token是否失效
            return true;
        }else {
            throw  new BizException("token已失效");
        }


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}