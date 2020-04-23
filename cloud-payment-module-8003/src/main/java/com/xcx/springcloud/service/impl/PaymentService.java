package com.xcx.springcloud.service.impl;

import com.xcx.springcloud.dao.PaymentDao;
import com.xcx.springcloud.entity.Payment;
import com.xcx.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/7 16:21
 * @Description:
 */
@Service
public class PaymentService implements IPaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public void savePaymentInfo(Payment payment) {
        paymentDao.savePaymentInfo(payment);
    }

    @Override
    public Payment queryPaymentInfo(Long id) {
        return paymentDao.queryPaymentInfo(id);
    }
}
