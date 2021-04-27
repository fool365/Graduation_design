package cn.com.jinkang.module.standard.service.personservice;

import cn.com.jinkang.module.standard.pojo.dto.person.CertifiedPersonnel;
import com.baomidou.mybatisplus.extension.service.IService;

public interface PersonService extends IService<CertifiedPersonnel> {
    CertifiedPersonnel selectOne(String username);
    CertifiedPersonnel selectPersonPhone(String phone);
}
