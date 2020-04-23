package com.xcx.springcloud.zk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/12 13:22
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentZK8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentZK8004.class,args);
        System.out.println("zk..payment8004启动成功");
    }
}
