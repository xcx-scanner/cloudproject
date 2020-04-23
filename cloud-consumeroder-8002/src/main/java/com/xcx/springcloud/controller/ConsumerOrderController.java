package com.xcx.springcloud.controller;

import com.xcx.springcloud.entity.Payment;
import com.xcx.springcloud.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/7 18:08
 * @Description:
 */
@RestController
@Slf4j
public class ConsumerOrderController {

    @Value("${restTemplate.url}")
    private  String URL;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 保存
     * @param payment
     * @return
     */
    @GetMapping(value="/consumer/savePaymentInfo")
    public CommonResult<Payment> savePaymentInfo(Payment payment){
        return restTemplate.postForObject(URL+"/savePaymentInfo",payment,CommonResult.class);
    }

    /**
     * 查询
     * @param:
     * @return: 
     * @auther: 肖朝翔
     * @date: 2020/3/7 18:26
     */
    @GetMapping(value="/consumer/queryPaymentInfo/{id}")
    public CommonResult<Payment> queryPaymentInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject(URL+"/queryPaymentInfo/"+id,CommonResult.class);
    }

    /**
     * 查询调用getForEntity方法
     * @param:
     * @return: 
     * @auther: 肖朝翔
     * @date: 2020/3/13 13:35
     */
    @GetMapping(value="/consumer/queryPaymentInfoByEntity/{id}")
    public CommonResult<Payment> queryPaymentInfoByEntity(@PathVariable("id") Long id) {
        //返回的是一个ResponseEntity对象，里面还包含了响应头 状态码 状态体等信息
        ResponseEntity<CommonResult>  responseEntity=restTemplate.getForEntity(URL+"/queryPaymentInfo/"+id,CommonResult.class);
        HttpStatus httpStatus=responseEntity.getStatusCode();
        if(null !=httpStatus && httpStatus.is2xxSuccessful()){
             return responseEntity.getBody();
        }
         return new CommonResult<Payment>(400,"操作失败");
    }
}
