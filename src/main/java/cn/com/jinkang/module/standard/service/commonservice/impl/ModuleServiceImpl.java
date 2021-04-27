package cn.com.jinkang.module.standard.service.commonservice.impl;

import cn.com.jinkang.module.standard.dao.commonmapper.ModuleMapper;
import cn.com.jinkang.module.standard.pojo.dto.common.Module;
import cn.com.jinkang.module.standard.service.commonservice.ModuleService;
import cn.com.jinkang.module.standard.util.pageutil.Condition;
import cn.com.jinkang.module.standard.util.pageutil.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements ModuleService {


    @Override
    public IPage<Module> select(Query page) {
        return baseMapper.selectPage(Condition.getPage(page),new QueryWrapper<Module>().lambda().orderByAsc(Module::getSort).eq(Module::isEnabled,true));
    }
}
