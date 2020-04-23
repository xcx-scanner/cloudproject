package com.xcx.springcloud.hystrix.controller;

import com.xcx.springcloud.entity.Payment;
import com.xcx.springcloud.hystrix.service.IHystrixPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/15 19:12
 * @Description:
 */
@RestController
@Slf4j
public class HystrixPaymentController {

     @Autowired
     private IHystrixPaymentService iHystrixPaymentService;
     /**
      * 获取数据
      * @param: 
      * @return: 
      * @auther: 肖朝翔
      * @date: 2020/3/15 19:14
      */
     @GetMapping(value = "/hystrix/queryPaymentInfo/{id}")
     public Payment queryPaymentInfo(@PathVariable("id") Long id){
         return iHystrixPaymentService.queryPaymentInfo(id);
    }

    /**
     * 模拟服务超时查询
     * @param:
     * @return: 
     * @auther: 肖朝翔
     * @date: 2020/3/15 19:26
     */
    @GetMapping(value = "/hystrix/queryPaymentInfoByTimeout/{id}")
    public Payment queryPaymentInfoByTimeout(@PathVariable("id") Long id){
        //模拟服务超时，睡眠5秒钟，开启Jmeter，模拟20000个并发来访问
        return iHystrixPaymentService.queryPaymentInfoByTimeout(id);
    }

    /**
     * 服务熔断
     * @param: 
     * @return: 
     * @auther: 肖朝翔
     * @date: 2020/3/16 18:43
     */
    @GetMapping(value = "/hystrix/queryPaymentInfoCircuitbreake/{id}")
    public Payment queryPaymentInfoCircuitbreake(@PathVariable("id") Long id){
        //模拟服务超时，睡眠5秒钟，开启Jmeter，模拟20000个并发来访问
        return iHystrixPaymentService.queryPaymentInfoCircuitbreake(id);
    }
}
