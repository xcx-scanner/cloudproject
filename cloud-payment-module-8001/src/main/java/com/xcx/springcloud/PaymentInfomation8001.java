package com.xcx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/7 15:21
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //配合DiscoveryClient一起使用，在主启动类上添加该注解使用DiscoveryClient时才能生效
public class PaymentInfomation8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentInfomation8001.class,args);
        System.out.println("8001启动成功");
    }
}
