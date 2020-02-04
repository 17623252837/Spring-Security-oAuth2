package com.hrh.oauth2.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @ProjectName: Spring-Security-oAuth2
 * @Package: com.hrh.oauth2.server.config
 * @ClassName: AuthorizationServerConfigurerAdapter
 * @Author: break
 * @Description:
 * @Date: 2019/7/17 0017 下午 15:52
 * @Version: 1.0
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // 获取code重定向地址
    @Value("${security.config.url}")
    private String url;
    // 授权类型
    @Value("${security.config.type}")
    private String type;
    // 授权范围
    @Value("${security.config.scope}")
    private String scope;
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        System.out.println(url);
        // 配置客户端
        clients
                // 使用内存设置
                .inMemory()
                // client_id
                .withClient("client")
                // client_secret
                .secret(passwordEncoder.encode("secret"))
                // 授权类型
                .authorizedGrantTypes(type)
                // 授权范围
                .scopes(scope)
                // 注册回调地址
                .redirectUris(url);
    }
}