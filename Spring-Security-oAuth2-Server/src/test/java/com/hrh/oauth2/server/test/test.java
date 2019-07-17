package com.hrh.oauth2.server.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ProjectName: Spring-Security-oAuth2
 * @Package: com.hrh.oauth2.server.test
 * @ClassName: test
 * @Author: break
 * @Description:
 * @Date: 2019/7/17 0017 下午 16:59
 * @Version: 1.0
 */
public class test {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("secret"));
    }
}
