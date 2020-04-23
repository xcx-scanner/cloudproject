package com.xcx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/12 20:32
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulComsumer8007 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulComsumer8007.class,args);
        System.out.println("consul...consumer8007 启动成功");
    }
}
