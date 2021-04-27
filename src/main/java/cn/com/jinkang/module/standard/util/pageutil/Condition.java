package cn.com.jinkang.module.standard.util.pageutil;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理分页类
 */
public class Condition {
    protected static final Logger logger = LoggerFactory.getLogger(Condition.class);


    public static <T> IPage<T> getPage(Query query) {
        query.setCurrent(ObjectUtil.isEmpty(query.getCurrent()) ? 0 : query.getCurrent());
        query.setSize(ObjectUtil.isEmpty(query.getSize()) ? 10 : query.getSize());
        if (query.getSize() > 200) {
            logger.debug("分页数据大小不能超过200位，当前为{}，默认修改为200", query.getSize());
            query.setSize(200);
        }

        Page<T> page = new Page((long)query.getCurrent(), (long)query.getSize());
        if (!ObjectUtil.isEmpty(query.getAscs())) {
            page.setAsc(query.getAscs().split(","));
        }

        if (!ObjectUtil.isEmpty(query.getDescs())) {
            page.setAsc(query.getDescs().split(","));
        }

        return page;
    }



}

