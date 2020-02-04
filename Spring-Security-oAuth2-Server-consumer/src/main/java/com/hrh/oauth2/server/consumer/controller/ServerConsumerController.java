package com.hrh.oauth2.server.consumer.controller;

import com.hrh.oauth2.server.consumer.dto.BaseResult;
import com.hrh.oauth2.server.consumer.service.ServerConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: Spring-Security-oAuth2
 * @Package: com.hrh.oauth2.server.consumer.controller
 * @ClassName: ServerConsumerController
 * @Author: HuRonghua
 * @Description: 接收spring-security的验证码并返回对应结果集
 * @Date: 2020/2/4 3:38
 * @Version: 1.0
 */
@RestController
@RequestMapping("/server/consumer/get")
public class ServerConsumerController {

    @Autowired
    private ServerConsumerService serverConsumerService;
    /**
     *
     * @param code 验证码
     * @return 结果集
     */
    @GetMapping("code")
    public BaseResult getCode(String code){
        return BaseResult.success("获取成功",code) ;
    }

    /**
     * 获取token
     * @param code 验证码
     * @return 结果集
     */
    @GetMapping("token/{code}")
    public String getToken(@PathVariable String code) {
        return serverConsumerService.getToken(code);
    }
}
