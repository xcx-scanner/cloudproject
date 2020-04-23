package com.xcx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/4/23 12:15
 * @Description:
 */
@SpringBootApplication
//激活配置中心
@EnableConfigServer
public class ConfigCenter5678 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter5678.class,args);
        System.out.println("ConfigCenter5678.......启动成功......");
    }
}
