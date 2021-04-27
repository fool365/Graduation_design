package cn.com.jinkang.module.standard.controller.processController;

import cn.com.jinkang.module.standard.pojo.dto.process.ProcessHistory;
import cn.com.jinkang.module.standard.pojo.dto.process.ProcessOrder;
import cn.com.jinkang.module.standard.service.processservice.ProcessHistoryService;
import cn.com.jinkang.module.standard.service.processservice.ProcessService;
import cn.com.jinkang.module.standard.util.pageutil.Query;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "流程模块")
@RequestMapping("/process")
@RestController
public class ProcessConller {
    @Autowired
    ProcessService processService;
    @Autowired
    ProcessHistoryService processHistoryService;

    /**
     * 查询流程订单数量
     * @param page
     * @param status
     * @return
     */
    @ApiOperation(value = "流程订单数量")
    @PostMapping("/selectProcessTitle")
    public IPage<ProcessOrder> selectProcessTitle(Query page, @RequestParam int status){

        return processService.selectProcess(page,status);
    }

    /**
     * 更改流程
     * @param processOrder 更改用户与流程状态
     * @return
     */
    @ApiOperation(value = "更改流程")
    @PostMapping("/updateStatus")
    public int updateStatus(@RequestBody ProcessOrder processOrder){
        return processService.updateStatus(processOrder);
    }

    /**
     * 分页查询流程订单
     * @param page
     * @param status
     * @return
     */
    @ApiOperation(value = "流程订单")
    @PostMapping("/selectProcess")
    public IPage<ProcessHistory>selectProcess(Query page,@RequestParam int status){
          return processHistoryService.selectProcess(page,status);
    }
}
