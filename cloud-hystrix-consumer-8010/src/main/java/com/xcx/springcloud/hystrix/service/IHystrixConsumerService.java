package com.xcx.springcloud.hystrix.service;

import com.xcx.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/15 22:33
 * @Description:
 */
@Component
@FeignClient(name = "XCX-CLOUD-HYSTRIX-PAYMENT-SERVICE",fallback = HystrixConsumeFallbackService.class) //使用feign来调用服务,指定服务名称
public interface IHystrixConsumerService {
    @GetMapping(value="/hystrix/queryPaymentInfoByTimeout/{id}")
     Payment queryPaymentInfo(@PathVariable("id") Long id);
}
