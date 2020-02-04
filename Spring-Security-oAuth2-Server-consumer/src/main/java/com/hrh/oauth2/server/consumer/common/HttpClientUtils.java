package com.hrh.oauth2.server.consumer.common;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @ProjectName: Spring-Security-oAuth2
 * @Package: com.hrh.oauth2.common
 * @ClassName: HttpClientUtils
 * @Author: HuRonghua
 * @Description: 网络请求工具类
 * @Date: 2020/2/4 4:22
 * @Version: 1.0
 */
@Component
public class HttpClientUtils {
    public static String httpPost(String uri, List<NameValuePair> params) {
        String result = "";
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(uri);
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded"); // 添加请求头
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            System.out.println(httpPost);
            HttpResponse response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instreams = entity.getContent();
                result = convertStreamToString(instreams);
                System.out.println(result);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return result;
    }


    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
