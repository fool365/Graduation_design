package cn.com.jinkang.module.standard.service.processlogservice.impl;

import cn.com.jinkang.module.standard.dao.log.ProcessLogMapper;
import cn.com.jinkang.module.standard.pojo.dto.processLog.ProcessLog;
import cn.com.jinkang.module.standard.service.processlogservice.ProcessLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProceseeLogServiceImpl extends ServiceImpl<ProcessLogMapper, ProcessLog> implements ProcessLogService {

    @Override
    public int insertLog(ProcessLog processLog) {
        return baseMapper.insert(processLog);
    }
}
