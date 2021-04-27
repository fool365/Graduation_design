package cn.com.jinkang.module.standard.service.userservice;

import cn.com.jinkang.module.standard.dao.usermapper.UserMapper;
import cn.com.jinkang.module.standard.pojo.dto.user.UserInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class MyUserDetailsService   {
    @Resource
    UserMapper userMapper;

    public  UserInfo loadUserByUsername(String username){

        return userMapper.selectOne(new QueryWrapper<UserInfo>().lambda().eq(UserInfo::getUsername,username));
    }
    public UserInfo selectOne(String username,String password){
        return userMapper.selectOne(new QueryWrapper<UserInfo>().lambda().eq(UserInfo::getUsername,username).eq(UserInfo::getPassword,password));
    }
}
