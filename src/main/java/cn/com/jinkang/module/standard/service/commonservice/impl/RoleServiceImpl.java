package cn.com.jinkang.module.standard.service.commonservice.impl;

import cn.com.jinkang.module.standard.dao.commonmapper.RoleMapper;
import cn.com.jinkang.module.standard.pojo.dto.common.Role;
import cn.com.jinkang.module.standard.service.commonservice.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Acer
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
