package com.xcx.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/7 18:16
 * @Description:
 */
@Configuration
public class ApplicationConfig {
    @Bean
    //负载均衡,单机版不需要使用该注解，直接在restTemplate调用的地方写入单机的IP与项目的端口号
    //调用服务者服务名称所对应的服务端集群时，加上该注解服务名称才能解析，实现负责均衡
    //服务调用时，需要指定服务集群所对应的注册的服务名称，在注册中心可以看到
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
