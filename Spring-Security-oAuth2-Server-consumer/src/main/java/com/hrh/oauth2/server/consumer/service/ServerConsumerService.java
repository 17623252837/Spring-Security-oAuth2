package com.hrh.oauth2.server.consumer.service;

import org.springframework.stereotype.Service;

/**
 * @ProjectName: Spring-Security-oAuth2
 * @Package: com.hrh.oauth2.server.consumer.service
 * @ClassName: ServerConsumerService
 * @Author: HuRonghua
 * @Description: 权限请求处理服务
 * @Date: 2020/2/5 5:04
 * @Version: 1.0
 */
@Service
public interface ServerConsumerService {
    // 获取access_token
    public String getToken(String code);
}
