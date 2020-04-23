package com.xcx.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/13 14:29
 * @Description:
 */
@Configuration
public class MyRibbonRule {
    
    /**
     * Ribbon随机规则
     * @param:
     * @return: 
     * @auther: 肖朝翔
     * @date: 2020/3/13 14:31
     */ 
    @Bean
    public IRule randRule(){
        return new RandomRule();
    }
}
