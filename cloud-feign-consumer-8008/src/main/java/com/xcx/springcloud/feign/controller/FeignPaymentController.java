package com.xcx.springcloud.feign.controller;

import com.xcx.springcloud.entity.Payment;
import com.xcx.springcloud.feign.service.IPaymentService;
import com.xcx.springcloud.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/14 14:27
 * @Description:
 */
@RestController
@Slf4j
public class FeignPaymentController {
    //封装的对外封装接口
    @Autowired
    private IPaymentService iPaymentService;

    @GetMapping(value="/consumer/queryPaymentInfo/{id}")
   public  CommonResult<Payment> queryPaymentInfo(@PathVariable("id") Long id){
     return iPaymentService.queryPaymentInfo(id);
    }
}
