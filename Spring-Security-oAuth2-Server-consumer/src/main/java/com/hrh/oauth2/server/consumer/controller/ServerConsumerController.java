package com.hrh.oauth2.server.consumer.controller;

import com.hrh.oauth2.server.consumer.common.HttpClientUtils;
import com.hrh.oauth2.server.consumer.dto.BaseResult;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    private HttpClientUtils httpClientUtils;
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
    public String getToken(@PathVariable String code) throws IOException {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("grant_type", "authorization_code"));
        nvps.add(new BasicNameValuePair("code", code));
        String s = HttpClientUtils.httpPost("http://client:secret@localhost:8080/oauth/token", nvps);
        return s;
    }
}
