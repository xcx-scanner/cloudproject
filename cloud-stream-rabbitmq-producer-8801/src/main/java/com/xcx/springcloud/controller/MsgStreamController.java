package com.xcx.springcloud.controller;


import com.xcx.springcloud.service.MsgStreamInfo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @Auther: 肖朝翔
 * @Date: 2020/4/23 21:17
 * @Description:
 */
@RestController
public class MsgStreamController {
    @Autowired
    private MsgStreamInfo msgStreamInfo;
    @GetMapping(value = "/sendMsg")
    public String sendMsg(){
        return msgStreamInfo.sendMsg();
    }
}
