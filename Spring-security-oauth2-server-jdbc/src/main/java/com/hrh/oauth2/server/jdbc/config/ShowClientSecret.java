package com.hrh.oauth2.server.jdbc.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ProjectName: Spring-Security-oAuth2
 * @Package: com.hrh.oauth2.server.jdbc.config
 * @ClassName: ShowClientSecret
 * @Author: HuRonghua
 * @Description: 生成加密码
 * @Date: 2020/2/6 16:36
 * @Version: 1.0
 */
public class ShowClientSecret {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("secret"));
    }
}
