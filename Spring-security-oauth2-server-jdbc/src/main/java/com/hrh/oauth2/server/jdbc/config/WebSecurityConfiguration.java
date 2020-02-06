package com.hrh.oauth2.server.jdbc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ProjectName: Spring-Security-oAuth2
 * @Package: com.hrh.oauth2.server.jdbc.config
 * @ClassName: WebSecurityConfiguration
 * @Author: HuRonghua
 * @Description: 服务器安全配置
 * @Date: 2020/2/6 15:00
 * @Version: 1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    // 登录名
    @Value("${security.users.name}")
    private String name;

    // 登录密码
    @Value("${security.users.password}")
    private String password;

    // 权限
    @Value("${security.users.role}")
    private String role;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 设置默认的加密方式
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                // 在内存中创建用户并为密码加密
                .withUser(name).password(passwordEncoder().encode(password)).roles(role)
                .and()
                .withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIN");
    }
}
