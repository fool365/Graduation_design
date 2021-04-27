package cn.com.jinkang.module.standard.service.processservice;

import cn.com.jinkang.module.standard.pojo.dto.process.ProcessOrder;
import cn.com.jinkang.module.standard.util.pageutil.Query;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ProcessService  extends IService<ProcessOrder> {
   /**
    * 分页查询流程
    * @param page
    * @param status
    * @return
    */
   IPage<ProcessOrder> selectProcess(Query page, int status);

   /**
    * 更改流程
    * @param processOrder
    * @return
    */
   int updateStatus(ProcessOrder processOrder);

}
