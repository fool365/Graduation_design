package cn.com.jinkang.module.standard.service.commonservice;

import cn.com.jinkang.module.standard.pojo.dto.common.Module;
import cn.com.jinkang.module.standard.util.pageutil.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ModuleService extends IService<Module> {
    IPage<Module> select(Query page);
}
