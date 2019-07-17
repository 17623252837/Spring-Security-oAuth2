package com.hrh.oauth2.resource.controller;

import com.hrh.oauth2.resource.domain.TbContent;
import com.hrh.oauth2.resource.dto.ResponseResult;
import com.hrh.oauth2.resource.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: Spring-Security-oAuth2
 * @Package: com.hrh.oauth2.resource.controller
 * @ClassName: TbContentController
 * @Author: break
 * @Description:
 * @Date: 2019/7/17 0017 下午 20:13
 * @Version: 1.0
 */
@RestController
public class TbContentController {
    @Autowired
    private TbContentService tbContentService;
    @GetMapping("/")
    ResponseResult<List<TbContent>> all(){
        System.out.println("mmp");
        return new ResponseResult<List<TbContent>>(Integer.valueOf(HttpStatus.OK.value()),HttpStatus.OK.toString(),tbContentService.selectAll());
    }

}
