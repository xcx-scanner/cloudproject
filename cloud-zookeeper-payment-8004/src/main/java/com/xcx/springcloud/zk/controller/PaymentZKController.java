package com.xcx.springcloud.zk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/12 13:24
 * @Description:
 */
@RestController
@Slf4j
public class PaymentZKController {
    @Value("${server.port}")
    private String serverPort;

    /**
     * 如果能获取到端口号表示已经注册到zk，也可以自行在zk上查看
     * @param: 
     * @return: 
     * @auther: 肖朝翔
     * @date: 2020/3/12 13:29
     */
    @GetMapping(value = "/paymentInfo")
    public String paymentInfo(){
        return "zookeeper:"+serverPort+"\t"+UUID.randomUUID();
    }
}
