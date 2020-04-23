package com.xcx.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/12 20:36
 * @Description:
 */
@RestController
@Slf4j
public class ConsulComsumerController {

    @Value("${cc.req.url}")
    private String requestUrl;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping(value = "/consumer/consul/paymentInfo")
    public String paymentInfo(){
        return restTemplate.getForObject(requestUrl+"/consul/paymentInfo",String.class);
    }
}
