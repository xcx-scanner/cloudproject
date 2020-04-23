package com.xcx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/4/23 12:57
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClient5679 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient5679.class,args);
        System.out.println("ConfigClient5679.......启动成功......");
    }
}
