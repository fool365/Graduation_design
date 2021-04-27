package cn.com.jinkang.module.standard.common.api;

import cn.com.jinkang.module.standard.common.constants.BaseGridReturn;
import cn.com.jinkang.module.standard.common.constants.RestResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
@Slf4j
public class CustomBuildResponseBody implements ResponseBodyAdvice {

    /**
     * 定义需要过滤的路径的关键字
     */
    private static final List<String> FILTER_URL_KEY = Lists.newArrayList("/swagger", "/v1/v2/", "/check_signature","/api-docs", "/metrics");

    private static final List<String> CLASS_WHITE_LIST = Lists.newArrayList("IndexController");

    @Override
    public boolean supports(MethodParameter methodParameter, Class clazz) {
        return !CLASS_WHITE_LIST.contains(methodParameter.getDeclaringClass().getSimpleName());
    }

    @Override
    public Object beforeBodyWrite(Object returnValue, MethodParameter methodParameter, MediaType mediaType,
                                  Class clazz,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if (isFilterUrl(serverHttpRequest)) {
            return returnValue;
        }

        if (Objects.isNull(returnValue)) {
            return new RestResult();
        }

        if (returnValue instanceof RestResult) {
            return returnValue;
        }

        if (returnValue instanceof Page) {
            return new RestResult(new BaseGridReturn((Page<?>) returnValue));
        }

        if (returnValue instanceof com.github.pagehelper.Page) {
            return new RestResult(new BaseGridReturn((com.github.pagehelper.Page<?>) returnValue));
        }

        return new RestResult(returnValue);
    }

    private boolean isFilterUrl(ServerHttpRequest serverHttpRequest) {
        URI uri = serverHttpRequest.getURI();
        String path = uri.getPath();
        return FILTER_URL_KEY.stream().anyMatch(path::contains);
    }
}
