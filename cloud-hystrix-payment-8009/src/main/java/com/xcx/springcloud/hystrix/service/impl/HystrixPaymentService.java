package com.xcx.springcloud.hystrix.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xcx.springcloud.entity.Payment;
import com.xcx.springcloud.hystrix.dao.HystrixPaymentDao;
import com.xcx.springcloud.hystrix.service.IHystrixPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/15 19:06
 * @Description:
 */
@Service
public class HystrixPaymentService implements IHystrixPaymentService {

    @Autowired
    private HystrixPaymentDao hystrixPaymentDao;

    /**
     * 获取数据
     * @param: 
     * @return: 
     * @auther: 肖朝翔
     * @date: 2020/3/15 19:11
     */
    @Override
    public Payment queryPaymentInfo(Long id){
        return hystrixPaymentDao.queryPaymentInfo(id);
    }

    /**
     * fallbackMethod：指定服务降级的方法,指定的服务降级的方法需要注意的是,方法返回值与参数必须与当前方法一致
     *HystrixProperty:name value 指定出现情况的类型，比如此处指定这个线程当超过Value指定的时间时,或者程序运行异常就进行降级
     * @param:
     * @return: 
     * @auther: 肖朝翔
     * @date: 2020/3/16 13:42
     */
    @HystrixCommand(fallbackMethod = "queryPaymentInfoFallback",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public Payment queryPaymentInfoByTimeout(Long id){
        //模拟服务超时，睡眠1秒钟，开启Jmeter，模拟20000个并发来访问
        int timeNumber=2000;
        try {
            Thread.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hystrixPaymentDao.queryPaymentInfo(id);
    }
    /**
     * 服务降级对应的方法，自定义逻辑
     * @param: 
     * @return: 
     * @auther: 肖朝翔
     * @date: 2020/3/16 13:44
     */
    public Payment queryPaymentInfoFallback(Long id){
           return Payment.builder().serialNo("系统繁忙稍后再试").id(999999L).build();
    }

    /* ----------------服务熔断----------------------------------*/

    //在10秒内10次请求中有60%是失败的，断路器就起作用
    @HystrixCommand(fallbackMethod = "queryinfCircuitFallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路由
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期(时间范围)
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") //失败利率达到多少后跳闸，即启动熔断
    })
    public Payment queryPaymentInfoCircuitbreake(Long id){
         if(id<=0){
             throw new RuntimeException("....Id值不正确.....");
         }
        return hystrixPaymentDao.queryPaymentInfo(id);
    }

    public Payment queryinfCircuitFallback(Long id){
        return Payment.builder().serialNo("服务熔断..Id值不正确").id(999999L).build();
    }

}
