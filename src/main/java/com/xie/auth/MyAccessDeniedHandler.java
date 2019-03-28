package com.xie.auth;

import com.alibaba.fastjson.JSON;
import com.xie.response.BaseResponse;
import com.xie.utils.MallConstants;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author xie
 * @summary summary
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 * @Description To change this template use File | Settings | File Temp
 * lates.
 * @since 2017-03-23 下午4:43
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        if (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            BaseResponse baseResponse = BaseResponse.fail(401, "未授权");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(JSON.toJSONString(baseResponse));
        } else if (request.getHeader(MallConstants.TOKEN_HEADER) != null && !request.getHeader(MallConstants.TOKEN_HEADER).equals("")) {
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            BaseResponse baseResponse = BaseResponse.fail(401, "未授权");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(JSON.toJSONString(baseResponse));
        }
    }
}
