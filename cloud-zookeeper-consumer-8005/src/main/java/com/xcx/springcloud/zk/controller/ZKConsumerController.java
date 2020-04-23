package com.xcx.springcloud.zk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/12 14:35
 * @Description:
 */
@RestController
@Slf4j
public class ZKConsumerController {
    @Value("${zk.server-url}")
    String zkServerUrl;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 调用zk服务，得到对应的值
     * @param: 
     * @return: 
     * @auther: 肖朝翔
     * @date: 2020/3/12 14:42
     */
    @GetMapping(value = "/zk/consumer/paymentInfo")
    private String paymentInfo(){
        String resultInfo = restTemplate.getForObject(zkServerUrl + "/paymentInfo", String.class);
        return resultInfo;
    }

}
