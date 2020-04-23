package com.xcx.springcloud.service;

import com.xcx.springcloud.entity.Payment;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/7 16:21
 * @Description:
 */
public interface IPaymentService {
    void savePaymentInfo(Payment payment);
    Payment queryPaymentInfo(Long id);
}
