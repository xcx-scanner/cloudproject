package com.xcx.springcloud.controller;


import com.xcx.springcloud.entity.Payment;
import com.xcx.springcloud.service.IPaymentService;
import com.xcx.springcloud.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    //获取注册中心信息比如端口号，主机名等等
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/queryPaymentInfo/{id}")
    public CommonResult<Payment> queryPaymentInfo(@PathVariable("id")Long id) throws InterruptedException {
        Payment paymentInfo=iPaymentService.queryPaymentInfo(id);
        CommonResult<Payment> commonResult=new CommonResult<Payment>();
        commonResult.setCode(200);
        commonResult.setMsg("success");
        commonResult.setData(paymentInfo);
        System.out.println("=======8001端口......");
        return commonResult;
    }

    @PostMapping(value = "savePaymentInfo")
    public CommonResult savePaymentInfo(@RequestBody Payment payment){
        try {
            iPaymentService.savePaymentInfo(payment);
            log.info("调用"+servicePort+"，微服务");
            return  new CommonResult(200,"success");
        } catch (Exception e) {
            log.info("error");
            log.error(e.getMessage());
        }
        return new CommonResult(505,"error");
    }

    /**
     * discoveryClient注册中心的信息获取
     * @param:
     * @return:
     * @auther: 肖朝翔
     * @date: 2020/3/9 16:10
     */
    @GetMapping(value = "/disconverInfo")
    public Object disconverInfo(){

        List<String> services = discoveryClient.getServices();
        for (String  info : services){
            log.info("service:"+info);
        }
        //注册中心对应的服务名称
        List<ServiceInstance> instances = discoveryClient.getInstances("XCX-CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance :instances){
            log.info(serviceInstance.getHost()+"/t"+serviceInstance.getInstanceId()+"/t"+serviceInstance.getPort());
        }
        return this.discoveryClient;
    }
}
