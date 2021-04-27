package cn.com.jinkang.module.standard.service.processservice.impl;

import cn.com.jinkang.module.standard.dao.process.ProcessMapper;
import cn.com.jinkang.module.standard.enums.ProcessStatusEnum;
import cn.com.jinkang.module.standard.pojo.dto.process.ProcessHistory;
import cn.com.jinkang.module.standard.pojo.dto.process.ProcessOrder;
import cn.com.jinkang.module.standard.pojo.dto.processLog.ProcessLog;
import cn.com.jinkang.module.standard.service.processlogservice.ProcessLogService;
import cn.com.jinkang.module.standard.service.processservice.ProcessHistoryService;
import cn.com.jinkang.module.standard.service.processservice.ProcessService;
import cn.com.jinkang.module.standard.util.BeanConvertUtil;
import cn.com.jinkang.module.standard.util.pageutil.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ProcessServiceImpl extends ServiceImpl<ProcessMapper, ProcessOrder> implements ProcessService {

    @Resource
    ProcessLogService processLogService;
    @Resource
    ProcessHistoryService processHistoryService;

    @Override
    public IPage<ProcessOrder> selectProcess(Query page, int status) {
        Page<ProcessOrder> page1 = BeanConvertUtil.convert(page,Page.class);
        IPage<ProcessOrder> iPage=baseMapper.selectPage(page1,new QueryWrapper<ProcessOrder>().lambda().eq(ProcessOrder::getStatus,status));
        for(ProcessOrder p:iPage.getRecords()){
            p.setName(ProcessStatusEnum.find(p.getStatus()).getMessage());
        }
        return iPage;
    }

    @Override
    @Transactional
    public int updateStatus(ProcessOrder processOrder) {
        int i=baseMapper.updateById(processOrder);
        if(i==1){
            ProcessLog processLog=new ProcessLog();
            processLog.setCreateBy(processOrder.getUpdateBy());
            processLog.setStatus(processOrder.getStatus());
            processLogService.insertLog(processLog);
            ProcessHistory processHistory=BeanConvertUtil.convert(processOrder,ProcessHistory.class);
            processHistoryService.insertProcessHistory(processHistory);
        }
        return i;
    }
}
