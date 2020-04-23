package com.xcx.springcloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/15 22:28
 * @Description:
 */
@SpringBootApplication
//使用Feign来进行服务负载均衡与调用，配置文件中没有配置说需要注入这个客户端服务
//所以不需要引入服务注册注解如@EnableDiscoveryClient注解
@EnableFeignClients
@EnableHystrix
public class HystrixConsumer8010 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixConsumer8010.class,args);
        System.out.println("Hystrix......Cosumer8010......启动成功");
    }
}
