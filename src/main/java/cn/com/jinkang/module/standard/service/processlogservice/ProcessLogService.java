package cn.com.jinkang.module.standard.service.processlogservice;

import cn.com.jinkang.module.standard.pojo.dto.processLog.ProcessLog;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ProcessLogService extends IService<ProcessLog> {
    int insertLog(ProcessLog processLog);
}
