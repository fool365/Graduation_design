package cn.com.jinkang.module.standard.controller.commonController;

import cn.com.jinkang.module.standard.pojo.dto.common.Module;
import cn.com.jinkang.module.standard.pojo.dto.equipment.Equipment;
import cn.com.jinkang.module.standard.service.commonservice.ModuleService;
import cn.com.jinkang.module.standard.util.pageutil.Query;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Acer
 */
@Api(value = "菜单模块")
@RequestMapping("/module")
@RestController
public class ModuleController {
    @Autowired
    ModuleService moduleService;
    @PostMapping("select")
    @ApiOperation(value = "工程信息管理->更改工程信息")
    public IPage<Module> select(Query page){
       return moduleService.select(page);
    }
}
