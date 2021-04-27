/*
 * Copyright (c) 2018 Cloud-Star, Inc. All Rights Reserved.
 */

package cn.com.jinkang.module.standard.common.exception;


import cn.com.jinkang.module.standard.common.constants.RestConst;
import cn.com.jinkang.module.standard.common.constants.RestResult;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


@Component
@Slf4j
public class GlobalHandlerExceptionResolver extends AbstractHandlerExceptionResolver {

    private static final String ORG_APACHE_SHIRO_AUTH = "org.apache.shiro.auth";
    private static final String IO_JSONWEBTOKEN = "io.jsonwebtoken";

    /**
     * 将错误信息添加到response中
     */
    private static void printWrite(String msg, HttpServletResponse response) {
        try {
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter pw = response.getWriter();
            pw.write(msg);
            pw.flush();
        } catch (Exception e) {
            log.error("Response write error: {}", e.getMessage());
        }
    }

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object o,
                                              Exception ex) {
        RestResult restResult = new RestResult();
        if (ex instanceof BizException) {
            restResult.setMessage(ex.getMessage()).setCode(((BizException) ex).getRestEnum())
                      .setStatus(RestResult.Status.FAILURE);
            response.setStatus(HttpServletResponse.SC_OK);
            log.warn("BizException: {}", ex.getMessage());
            if (log.isDebugEnabled()) {
                log.debug("BizException: " + ex.getMessage(), ex);
            }
        } else if (ex instanceof BizException) {
            restResult.setMessage(ex.getMessage());
            restResult.put("code",
                           ((BizException) ex).getRestEnum().getCode());
            restResult.setStatus(RestResult.Status.FAILURE);
            response.setStatus(HttpServletResponse.SC_OK);
//            ex.printStackTrace();
            log.warn("BizException: {}", ex.getMessage());
            if (log.isDebugEnabled()) {
                log.debug("BizException: " + ex.getMessage(), ex);
            }
        }  else if (ex instanceof BizException) {
            restResult.setMessage(ex.getMessage());
            restResult.put("code",
                           ((BizException) ex).getRestEnum().getCode());
            restResult.setStatus(RestResult.Status.FAILURE);
            response.setStatus(HttpServletResponse.SC_OK);
//            ex.printStackTrace();
            log.warn("BizException: {}", ex.getMessage());
            if (log.isDebugEnabled()) {
                log.debug("BizException: " + ex.getMessage(), ex);
            }
        } else if (ex instanceof DataNotExistException) {
            restResult.setMessage(ex.getMessage()).setCode(DataNotExistException.class.cast(ex).getRestEnum())
                      .setStatus(RestResult.Status.FAILURE)
                      .setCode(RestConst.HttpConst.NotFound)
                      .setData("RES_NOT_FOUND");
            response.setStatus(HttpServletResponse.SC_OK);
        } else if (ex instanceof ForbiddenBizException) {
            restResult.setMessage(ex.getMessage()).setCode(RestConst.BizError.BIZ_ERROR)
                      .setStatus(RestResult.Status.FAILURE);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else if (ex.getClass().getName().startsWith(ORG_APACHE_SHIRO_AUTH)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else if (ex.getClass().getName().startsWith(IO_JSONWEBTOKEN)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else if (ex instanceof IllegalArgumentException) {
            ex.printStackTrace();
            restResult.setMessage(ex.getMessage()).setCode(RestConst.BizError.BAD_PARAM)
                      .setStatus(RestResult.Status.FAILURE);
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            // 针对client端请求超时关闭通道引起的io错误，返回null，不再写数据到前端
            if (StrUtil.containsIgnoreCase(ExceptionUtil.getMessage(ex), "Broken pipe")) {
                log.warn("Client about request without send FIN: {}", ex.getMessage());
                return null;
            }
            // 非捕获的java/javax异常系，作为系统错误输出
            restResult.setMessage("系统错误，请联系管理员。").setCode(RestConst.SysError.SYS_ERROR)
                      .setStatus(RestResult.Status.FAILURE);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            log.error("内部错误发生:", ex);
        }
        printWrite(JSONObject.toJSONString(restResult), response);
        return new ModelAndView();
    }
}
