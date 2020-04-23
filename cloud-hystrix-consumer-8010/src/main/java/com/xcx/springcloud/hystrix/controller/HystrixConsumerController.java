package com.xcx.springcloud.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xcx.springcloud.entity.Payment;
import com.xcx.springcloud.hystrix.service.IHystrixConsumerService;
import com.xcx.springcloud.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/15 22:37
 * @Description:
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallbakMethod")
public class HystrixConsumerController {

    @Autowired
    private IHystrixConsumerService iHystrixConsumerService;

    @GetMapping(value="/hystrix/consumer/queryPaymentInfo/timeout/{id}")
    public CommonResult<Payment> queryPaymentInfo(@PathVariable("id") Long id){
         Payment  info=iHystrixConsumerService.queryPaymentInfo(id);
         return CommonResult.<Payment>builder().data(info).code(200).msg("sucess").build();
    }

    /**
     * 服务降级
     * fallbackMethod：指定服务降级的方法,指定的服务降级的方法需要注意的是,方法返回值与参数必须与当前方法一致
     *HystrixProperty:name value 指定出现情况的类型，比如此处指定这个线程当超过Value指定的时间(毫秒),或者程序运行异常就进行降级
     * @return:
     * @auther: 肖朝翔
     * @date: 2020/3/16 13:42
     */
    @HystrixCommand(fallbackMethod = "queryPaymentInfoCousumerFallback",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    @GetMapping(value="/hystrix/consumer/queryPaymentInfo/queryPaymentInfoCircuit/{id}")
    public CommonResult<Payment> queryPaymentInfoCircuit(@PathVariable("id") Long id){
        Payment  info=iHystrixConsumerService.queryPaymentInfo(id);
        return CommonResult.<Payment>builder().data(info).code(200).msg("sucess").build();
    }
    /**
     * 服务降级对应的方法，自定义逻辑
     * @param:
     * @return:
     * @auther: 肖朝翔
     * @date: 2020/3/16 13:44
     */
    public CommonResult<Payment> queryPaymentInfoCousumerFallback(Long id){
        Payment payment=Payment.builder().serialNo("Hystrix客户端超时访问....").id(99999999L).build();
        return CommonResult.<Payment>builder().data(payment).build();
    }


    /**
     * 全局降级处理方法
     * @param:
     * @return: 
     * @auther: 肖朝翔
     * @date: 2020/3/16 16:45
     */
    public CommonResult<Payment> globalFallbakMethod(){
        Payment payment=Payment.builder().serialNo("Hystrix客户端繁忙.....请稍后再试").build();
        return CommonResult.<Payment>builder().data(payment).build();
    }

    /**
     * 使用了配置的全局服务降级
     * 要想使用全局服务降级，必须加上@HystrixCommnad注解，否则如果超时、报错就会直接提示不会服务降级
     * @param:
     * @return: 
     * @auther: 肖朝翔
     * @date: 2020/3/16 16:49
     */
    @HystrixCommand
    @GetMapping(value="/hystrix/consumer/queryPaymentInfo/global/{id}")
    public CommonResult<Payment> queryPaymentInfoGlobalHystrix(@PathVariable("id") Long id){
        Payment  info=iHystrixConsumerService.queryPaymentInfo(id);
        return CommonResult.<Payment>builder().data(info).code(200).msg("sucess").build();
    }
}
