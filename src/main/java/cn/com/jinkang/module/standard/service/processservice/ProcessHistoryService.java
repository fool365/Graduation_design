package cn.com.jinkang.module.standard.service.processservice;

import cn.com.jinkang.module.standard.pojo.dto.process.ProcessHistory;
import cn.com.jinkang.module.standard.util.pageutil.Query;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ProcessHistoryService extends IService<ProcessHistory> {
    /**
     * 添加流程
     * @param processHistory
     * @return
     */
    int insertProcessHistory(ProcessHistory processHistory);

    /**
     * 分页查询流程订单
     * @param page
     * @param status
     * @return
     */
    IPage<ProcessHistory> selectProcess(Query page,int status);
}
