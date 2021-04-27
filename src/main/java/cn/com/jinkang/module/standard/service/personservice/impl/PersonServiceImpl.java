package cn.com.jinkang.module.standard.service.personservice.impl;

import cn.com.jinkang.module.standard.dao.personmapper.PersonMapper;
import cn.com.jinkang.module.standard.pojo.dto.person.CertifiedPersonnel;
import cn.com.jinkang.module.standard.service.personservice.PersonService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, CertifiedPersonnel> implements PersonService {
    @Resource
    PersonMapper personMapper;


    @Override
    public CertifiedPersonnel selectOne(String username) {
        return personMapper.selectOneByUsername(username);
    }

    @Override
    public CertifiedPersonnel selectPersonPhone(String phone) {
        return baseMapper.selectOne(new QueryWrapper<CertifiedPersonnel>().lambda().eq(CertifiedPersonnel::getPhone,phone));
    }
}
