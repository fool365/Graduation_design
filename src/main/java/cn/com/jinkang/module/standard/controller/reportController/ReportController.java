package cn.com.jinkang.module.standard.controller.reportController;

import cn.com.jinkang.module.standard.common.constants.result.R;
import cn.com.jinkang.module.standard.service.wordexportservice.WordExportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "报告")
@RequestMapping("/report")
@RestController
public class ReportController {
    @Autowired
    WordExportService wordExportService;

    /**
     * 导出word文档
     * @return
     */
    @ApiOperation(value = "导出word文档")
//    @PostMapping("/exportWord")
    @GetMapping("/exportWord")
    public R exportWord(){
        return R.data(wordExportService.exportWord());
    }

}
