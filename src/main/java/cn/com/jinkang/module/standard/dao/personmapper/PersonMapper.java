package cn.com.jinkang.module.standard.dao.personmapper;

import cn.com.jinkang.module.standard.pojo.dto.person.CertifiedPersonnel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PersonMapper extends BaseMapper<CertifiedPersonnel> {
    /**
     * 根据用户名查询
     * @return
     */
    @Select("SELECT p.id,p.serial_number,p.name,p.level,p.professional,p.hiredate,p.card_time,p.due_time,p.start_time,p.registered,p.registration_time,p.departure_time,p.create_time,p.update_time,p.phone FROM certified_personnel p,user u,user_person u_p WHERE u.id=u_p.uid and p.id=u_p.pid and u.username=#{username}")
    CertifiedPersonnel selectOneByUsername(@Param("username") String username);

}
