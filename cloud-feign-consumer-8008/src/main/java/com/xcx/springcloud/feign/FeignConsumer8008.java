package com.xcx.springcloud.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/14 14:16
 * @Description:
 */
@SpringBootApplication
@EnableFeignClients //激活,开启Fegin
public class FeignConsumer8008 {
    public static void main(String[] args) {
        SpringApplication.run(FeignConsumer8008.class,args);
        System.out.println("Fegin....Consumer8008启动成功.......");
    }
}
