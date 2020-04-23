package com.xcx.springcloud.hystrix;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/15 19:04
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker //启用 激活 服务熔断
public class HystrixPayment8009 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPayment8009.class,args);
        System.out.println("Hystrix..............Payment8009启动成功");
    }

    /**
     * 引入9001模块的HystrixDashbord图形化监控必须加上这个
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
