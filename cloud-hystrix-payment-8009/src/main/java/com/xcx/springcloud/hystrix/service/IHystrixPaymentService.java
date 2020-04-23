package com.xcx.springcloud.hystrix.service;

import com.xcx.springcloud.entity.Payment;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/15 19:06
 * @Description:
 */
public interface IHystrixPaymentService {
    /**
     * 正常访问
     * @param:
     * @return: 
     * @auther: 肖朝翔
     * @date: 2020/3/16 13:37
     */
    Payment queryPaymentInfo(Long id);
    /**
     * 超时访问
     * @param:
     * @return: 
     * @auther: 肖朝翔
     * @date: 2020/3/16 13:37
     */
    Payment queryPaymentInfoByTimeout(Long id);

    /**
     * 服务熔断
     * @param:
     * @return: 
     * @auther: 肖朝翔
     * @date: 2020/3/16 18:41
     */
    Payment queryPaymentInfoCircuitbreake(Long id);
    
}
