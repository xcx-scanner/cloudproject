package com.xcx.springcloud.dao;

import com.xcx.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/7 16:01
 * @Description:
 * dao与数据库交互lombok可以使用@Mapper
 * 不使用@Repository 因为有时候会有问题
 */
@Mapper
public interface PaymentDao {
    void savePaymentInfo(Payment payment);
    Payment queryPaymentInfo(Long id);
}
