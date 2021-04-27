package cn.com.jinkang.module.standard.service.processservice.impl;

import cn.com.jinkang.module.standard.dao.process.ProcessHistoryMapper;
import cn.com.jinkang.module.standard.pojo.dto.process.ProcessHistory;
import cn.com.jinkang.module.standard.service.processservice.ProcessHistoryService;
import cn.com.jinkang.module.standard.util.pageutil.Condition;
import cn.com.jinkang.module.standard.util.pageutil.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProcessHistoryServiceImpl extends ServiceImpl<ProcessHistoryMapper, ProcessHistory> implements ProcessHistoryService {
    @Override
    public int insertProcessHistory(ProcessHistory processHistory) {
        return baseMapper.insert(processHistory);
    }

    @Override
    public IPage<ProcessHistory> selectProcess(Query page, int status) {
        return baseMapper.selectPage(Condition.getPage(page),new QueryWrapper<ProcessHistory>().lambda().eq(ProcessHistory::getStatus,status));
    }
}
