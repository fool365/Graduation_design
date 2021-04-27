package cn.com.jinkang.module.standard.dao.usermapper;

import cn.com.jinkang.module.standard.pojo.dto.user.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserInfo>{
}
