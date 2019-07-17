package com.hrh.oauth2.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ProjectName: Spring-Security-oAuth2
 * @Package: com.hrh.outh2.resource
 * @ClassName: oauth2ResourceApplication
 * @Author: break
 * @Description:
 * @Date: 2019/7/17 0017 下午 20:02
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = "com.hrh.oauth2.resource.mapper")
public class oauth2ResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(oauth2ResourceApplication.class,args);
    }
}
