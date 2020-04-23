package com.xcx.springcloud.hystrix.dao;

import com.xcx.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/15 19:08
 * @Description:
 */
@Mapper
public interface HystrixPaymentDao {
    Payment queryPaymentInfo(Long id);
}
