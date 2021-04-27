package cn.com.jinkang.module.standard.dao.log;

import cn.com.jinkang.module.standard.pojo.dto.processLog.ProcessLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProcessLogMapper  extends BaseMapper<ProcessLog> {
}
