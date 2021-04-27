package cn.com.jinkang.module.standard.controller.equipmentController;

import cn.com.jinkang.module.standard.common.constants.result.R;
import cn.com.jinkang.module.standard.pojo.dto.equipment.Equipment;
import cn.com.jinkang.module.standard.service.equipmentservice.EquipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "工程信息管理")
@RequestMapping("/equipment")
@RestController
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;

    @PostMapping("updateEquipment")
    @ApiOperation(value = "工程信息管理->更改工程信息")
    public int updateEquipment(@RequestBody Equipment equipment){

    return  equipmentService.updeteEquipment(equipment);
    }
    @PostMapping("insertEquipment")
    @ApiOperation(value = "工程信息管理->添加工程信息")
    public int insertEquipment(@RequestBody Equipment equipment){
        return equipmentService.insertEquipment(equipment);
    }
    @PostMapping("selectOne")
    @ApiOperation(value = "工程信息管理->查询")
    public Equipment selectOne(@RequestParam int id){
        return  equipmentService.selectEquipment(id);
    }
}
