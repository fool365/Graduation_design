package cn.com.jinkang.module.standard.service.equipmentservice.impl;

import cn.com.jinkang.module.standard.common.constants.result.R;
import cn.com.jinkang.module.standard.dao.equipmentmapper.EquipmentMapper;
import cn.com.jinkang.module.standard.pojo.dto.equipment.Equipment;
import cn.com.jinkang.module.standard.service.equipmentservice.EquipmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl  extends ServiceImpl<EquipmentMapper, Equipment> implements EquipmentService {


    @Override
    public int updeteEquipment(Equipment equipment) {
        return baseMapper.updateById(equipment);
    }

    @Override
    public int insertEquipment(Equipment equipment) {
        return insertEquipment(equipment);
    }

    @Override
    public Equipment selectEquipment(int id) {
        return baseMapper.selectById(id);
    }
}
