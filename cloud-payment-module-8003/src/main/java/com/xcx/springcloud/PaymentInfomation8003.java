package com.xcx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/7 15:21
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentInfomation8003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentInfomation8003.class,args);
        System.out.println("8003启动成功");
    }
}
