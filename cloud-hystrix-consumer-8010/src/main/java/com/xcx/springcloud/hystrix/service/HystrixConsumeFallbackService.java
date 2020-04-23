package com.xcx.springcloud.hystrix.service;

import com.xcx.springcloud.entity.Payment;
import org.springframework.stereotype.Service;

/**
 * 此类用于统配服务降级，当服务调用方宕机了 进行服务降级
 * @Auther: 肖朝翔
 * @Date: 2020/3/16 17:07
 * @Description:
 */
@Service
public class HystrixConsumeFallbackService implements IHystrixConsumerService {
    @Override
    public Payment queryPaymentInfo(Long id) {
        return Payment.builder().serialNo("HystrixConsumeFallbackService....宕机了 统配降级服务").build();
    }
}
