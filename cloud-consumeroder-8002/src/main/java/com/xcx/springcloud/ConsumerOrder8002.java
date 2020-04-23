package com.xcx.springcloud;

import com.xcx.ribbon.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/7 18:02
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
//启用Ribbon并制定负载均衡策略，如果使用Ribbon可以不需要加 比如直接使用RestTemplate，这里就不需要加这个注解
//name制定注册中心需要调用的服务名称,自定义Ribbon负载均衡策略
@RibbonClient(name = "XCX-CLOUD-PAYMENT-SERVICE",configuration = MyRibbonRule.class)
public class ConsumerOrder8002 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrder8002.class,args);
        System.out.println("8002启动成功");
    }
}
