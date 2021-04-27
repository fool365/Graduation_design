package cn.com.jinkang.module.standard.service.equipmentservice;

import cn.com.jinkang.module.standard.common.constants.result.R;
import cn.com.jinkang.module.standard.pojo.dto.equipment.Equipment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;


public interface EquipmentService extends IService<Equipment> {
   int updeteEquipment(Equipment equipment);
   int insertEquipment(Equipment equipment);
   Equipment selectEquipment(int id);

     //操作日志
    //提醒设备维修

}
