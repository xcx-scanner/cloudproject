package com.xcx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/4/23 21:05
 * @Description:
 */
@SpringBootApplication
public class StreamRabbitMQ8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMQ8801.class,args);
        System.out.println("StreamRabbitMQ8801......启动成功......");
    }
}
