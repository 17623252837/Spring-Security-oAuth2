package com.hrh.oauth2.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ProjectName: Spring-Security-oAuth2
 * @Package: com.hrh.oauth2
 * @ClassName: Oauth2Application
 * @Author: break
 * @Description:
 * @Date: 2019/7/17 0017 下午 15:48
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = "com.hrh.oauth2.server.mapper")
public class OAuth2ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2ServerApplication.class,args);
    }
}
