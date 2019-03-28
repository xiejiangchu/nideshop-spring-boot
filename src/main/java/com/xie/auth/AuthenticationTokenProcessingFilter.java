package com.xie.auth;

import com.xie.utils.MallConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author xie
 * @summary summary
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 * @Description To change this template use File | Settings | File Temp
 * lates.
 * @since 2017-03-24 上午8:27
 */
@Component
public class AuthenticationTokenProcessingFilter extends GenericFilterBean {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    MyAccessDeniedHandler myAccessDeniedHandler;
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (httpServletRequest.getRequestURL().toString().endsWith("/login")) {
            chain.doFilter(request, response);
            return;
        }

        Map<String, String[]> params = httpServletRequest.getParameterMap();
        String headParams = httpServletRequest.getHeader(MallConstants.TOKEN_HEADER);
        if (params.containsKey(MallConstants.TOKEN_HEADER) || (headParams != null && !headParams.equals(""))) {
            String token = params.get(MallConstants.TOKEN_HEADER) == null ? headParams : params.get(MallConstants.TOKEN_HEADER)[0];
            if (token == null) {
                throw new BadCredentialsException("账户未找到");
            }
            // determine the user based on the (already validated) token
            try {
                MyUserDetails myUserDetails = (MyUserDetails) myUserDetailsService.loadUserByUsername(token);
                if (myUserDetails.isAccountNonExpired() && myUserDetails.isEnabled()) {
                    // build an Authentication object with the user's info
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(myUserDetails, myUserDetails.getPassword(), myUserDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails((HttpServletRequest) request));
                    // set the authentication into the SecurityContext
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    myAccessDeniedHandler.handle(httpServletRequest, httpServletResponse, new AccessDeniedException("未获取到登录信息"));
                    return;
                }
            } catch (UsernameNotFoundException exception) {
                myAccessDeniedHandler.handle(httpServletRequest, httpServletResponse, new AccessDeniedException("未获取到登录信息"));
                return;
            }
        }
        chain.doFilter(request, response);
    }
}
