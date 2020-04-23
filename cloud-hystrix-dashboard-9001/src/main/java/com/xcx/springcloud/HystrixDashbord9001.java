package com.xcx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/16 19:14
 * @Description:
 */
@SpringBootApplication
@EnableHystrixDashboard //HystrixDashboard图形化注解
public class HystrixDashbord9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashbord9001.class,args);
    }
}
