package com.xcx.springcloud.controller;

import com.xcx.springcloud.entity.Payment;
import com.xcx.springcloud.service.IPaymentService;
import com.xcx.springcloud.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/7 17:03
 * @Description:
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private IPaymentService iPaymentService;

    @Value("${server.port}")
    private String servicePort;

    @GetMapping(value = "/queryPaymentInfo/{id}")
    public CommonResult<Payment> queryPaymentInfo(@PathVariable("id")Long id) throws InterruptedException {
        Payment paymentInfo=iPaymentService.queryPaymentInfo(id);
        CommonResult<Payment> commonResult=new CommonResult<Payment>();
        commonResult.setCode(200);
        commonResult.setMsg("success");
        commonResult.setData(paymentInfo);
        System.out.println("=======8003端口......");
        return commonResult;
    }

    @PostMapping(value = "savePaymentInfo")
    public CommonResult savePaymentInfo(@RequestBody Payment payment){
        try {
            log.info("调用"+servicePort+"，微服务");
            iPaymentService.savePaymentInfo(payment);
            log.info("success");
            return  new CommonResult(200,"success");
        } catch (Exception e) {
            log.info("error");
            log.error(e.getMessage());
        }
        return new CommonResult(505,"error");
    }
}
