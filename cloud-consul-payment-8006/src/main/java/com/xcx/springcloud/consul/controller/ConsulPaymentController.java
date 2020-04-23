package com.xcx.springcloud.consul.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/12 19:07
 * @Description:
 */
@RestController
@Slf4j
public class ConsulPaymentController {
    @Value("${server.port}")
    private String serverPort;

    
    /**
     * 如果能获取到端口号表示已经注册到Consul，也可以自行在Consul上查看
     * @param: 
     * @return: 
     * @auther: 肖朝翔
     * @date: 2020/3/12 19:09
     */
    @GetMapping(value = "/consul/paymentInfo")
    public String paymentInfo(){
        return "consul:"+serverPort+"\t"+UUID.randomUUID();
    }
}
