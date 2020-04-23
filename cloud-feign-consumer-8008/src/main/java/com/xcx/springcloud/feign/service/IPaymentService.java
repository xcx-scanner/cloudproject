package com.xcx.springcloud.feign.service;

import com.xcx.springcloud.entity.Payment;
import com.xcx.springcloud.util.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 这个类主要是用来封装服务调用的接口，里面方法就是服务端对应的方法，只不过这里把返回值进行封装了
 * @Auther: 肖朝翔
 * @Date: 2020/3/14 14:19
 * @Description:
 */
@Component
@FeignClient(value = "XCX-CLOUD-PAYMENT-SERVICE") //使用feign，指定服务名称
public interface IPaymentService {

    //此接与XCX-CLOUD-PAYMENT-SERVICE服务端接口所对应，这不过这里把方法返回值进行封装了
    //此处路径对应的是XCX-CLOUD-PAYMENT-SERVICE集群服务端所对应的路径
    //如在8001模块中有个路径为/queryPaymentInfo/{id} Fegin会自动找到所指定的服务XCX-CLOUD-PAYMENT-SERVICE中对应路径的方法
     @GetMapping(value="/queryPaymentInfo/{id}")
     CommonResult<Payment> queryPaymentInfo(@PathVariable("id") Long id);
}
