package com.hrh.oauth2.server.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ProjectName: Spring-Security-oAuth2
 * @Package: com.hrh.oauth2.server.jdbc
 * @ClassName: OAuth2ServerJdbcApplication
 * @Author: HuRonghua
 * @Description: jdbc存储令牌入口类
 * @Date: 2020/2/6 14:31
 * @Version: 1.0
 */
@SpringBootApplication
public class OAuth2ServerJdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2ServerJdbcApplication.class,args);
    }
}
