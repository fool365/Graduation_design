package cn.com.jinkang.module.standard.dao.process;

import cn.com.jinkang.module.standard.pojo.dto.process.ProcessOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProcessMapper  extends BaseMapper<ProcessOrder> {
}
