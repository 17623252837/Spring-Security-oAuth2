package com.hrh.oauth2.server.consumer.service.impl;

import com.hrh.oauth2.server.consumer.common.HttpClientUtils;
import com.hrh.oauth2.server.consumer.service.ServerConsumerService;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Spring-Security-oAuth2
 * @Package: com.hrh.oauth2.server.consumer.service.impl
 * @ClassName: ServerConsumerServiceImpl
 * @Author: HuRonghua
 * @Description: 实现类
 * @Date: 2020/2/5 5:07
 * @Version: 1.0
 */
public class ServerConsumerServiceImpl implements ServerConsumerService {

    @Override
    public String getToken(String code) {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("grant_type", "authorization_code"));
        nvps.add(new BasicNameValuePair("code", code));
        String s = HttpClientUtils.httpPost("http://client:secret@localhost:8080/oauth/token", nvps);
        return s;
    }
}
