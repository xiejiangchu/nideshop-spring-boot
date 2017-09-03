package com.xie.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author xie
 * @summary summary
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 * @Description To change this template use File | Settings | File Temp
 * lates.
 * @since 2017-03-23 下午3:49
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        MyUserDetails myUserDetails = (MyUserDetails) myUserDetailsService.loadUserByUsername(username);
        if (myUserDetails == null) {
            throw new BadCredentialsException("用户名未找到");
        }

        //加密过程在这里体现
        if (!bCryptPasswordEncoder.matches(password, myUserDetails.getPassword())) {
            throw new BadCredentialsException("密码错误!");
        }

        if (myUserDetails.isAccountNonExpired() && myUserDetails.isAccountNonLocked()) {
            Collection<? extends GrantedAuthority> authorities = myUserDetails.getAuthorities();
            return new UsernamePasswordAuthenticationToken(myUserDetails, password, authorities);
        } else {
            throw new BadCredentialsException("账户被锁或者已过有效期");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
