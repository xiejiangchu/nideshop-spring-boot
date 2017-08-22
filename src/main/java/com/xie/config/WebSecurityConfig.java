package com.xie.config;

import com.xie.auth.AuthenticationTokenProcessingFilter;
import com.xie.auth.MyAccessDeniedHandler;
import com.xie.auth.MyAuthenticationProvider;
import com.xie.auth.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

/**
 * @Author xie
 * @Date 17/1/19 下午4:32.
 */
@Configuration
@EnableWebSecurity(debug = false)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService myUserDetailsService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private MyAuthenticationProvider myAuthenticationProvider;//自定义验证
    @Autowired
    private AuthenticationTokenProcessingFilter authenticationTokenProcessingFilter;
    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }

    //Let’s you specify a custom LogoutSuccessHandler. If this is specified, logoutSuccessUrl() is ignored. For for information,
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
//        http.addFilterBefore(authenticationTokenProcessingFilter, UsernamePasswordAuthenticationFilter.class)
//                .authorizeRequests()
//                .antMatchers("/js/**","/img/**","/admin/html/**", "/admin/js/**", "/admin/template/**", "/admin/*.html", "/css/**", "/**/favicon.ico").permitAll()
//                .antMatchers("/", "index", "/banner/list", "/category/**", "/item/*").permitAll()
//                .antMatchers("/user/get3rdSession", "/user/login").permitAll()
//                .antMatchers("/sysConfig/**").permitAll()
//                .antMatchers("/wechat/server").permitAll()
//                .antMatchers("/error").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin().loginPage("/login.html").usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/admin", true).failureUrl("/login.html?error=true").permitAll()
//                .and().logout().permitAll().logoutUrl("/logout").logoutSuccessUrl("/admin/index").invalidateHttpSession(true)
//                .and().exceptionHandling().accessDeniedHandler(myAccessDeniedHandler);
//                .and().addFilterAfter(new MyCsrfHeaderFilter(), CsrfFilter.class);
//        http.csrf().requireCsrfProtectionMatcher(myCsrfSecurityRequestMatcher).csrfTokenRepository(csrfTokenRepository());

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("administrator").password("112233").roles("USER");
        auth.userDetailsService(myUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
        auth.authenticationProvider(myAuthenticationProvider);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**");
        web.ignoring().antMatchers("/register");
    }


}