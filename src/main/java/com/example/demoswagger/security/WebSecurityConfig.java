package com.example.demoswagger.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Profile({"rls","test","prod"})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // if ("dev,local".indexOf(active) < 0) {
        if (true) {
            http
                    .authorizeRequests()
                    .antMatchers("/static/**").permitAll()//定义/请求不需要验证
                    .antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
                            "/configuration/security", "/swagger-ui.html", "/webjars/**").permitAll()
                    .antMatchers("/proxy/qiyeweixin/token").permitAll()
                    .antMatchers("/proxy/qiyeWeiChat/user-profile").permitAll()
                    // .antMatchers("/base/**").permitAll()
                    .anyRequest().authenticated()//其余的所有请求都需要验证
                    .and()
                    .formLogin()
                    .loginPage("/login")//指定登录页是”/login”
                    .permitAll()
                    .and()
                    .logout()
                    .permitAll()
                    .invalidateHttpSession(true);
        }
    }


}