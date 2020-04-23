package com.xcx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/4/23 14:33
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class RabbitMQConfigClient5680 {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQConfigClient5680.class,args);
        System.out.println("RabbitMQConfigClient5680.......启动成功........");
    }
}
