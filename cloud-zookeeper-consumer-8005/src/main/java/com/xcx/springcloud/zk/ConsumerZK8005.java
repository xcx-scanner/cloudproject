package com.xcx.springcloud.zk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/12 14:31
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class ConsumerZK8005 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZK8005.class,args);
        System.out.println("consumer8005 启动成功");
    }
}
