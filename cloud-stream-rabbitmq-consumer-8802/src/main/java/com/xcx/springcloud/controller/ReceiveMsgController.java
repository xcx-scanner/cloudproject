package com.xcx.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.*;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Auther: 肖朝翔
 * @Date: 2020/4/24 12:52
 * @Description:
 */
@RestController
@EnableBinding(Sink.class)
public class ReceiveMsgController {
    @Value("${server.port}")
    private String portInfo;

    /**
     * 接受消息
     * @StreamListener 固定写法，通过@StreamListener来监听消息
     * Sink.INPUT)表示为一个输入源，即为一个消费者
     * Message<String> msgs 固定写法，表示所接受到的消息
     * 因为我们消费者的配置文件已经指定了Exchange为生产者所对应的
     * 所以当在同一Exchange发送的消息都可以接收到
     * @param:
     * @return: 
     * @auther: 肖朝翔
     * @date: 2020/4/24 13:00
     */
    @StreamListener(Sink.INPUT) 
    public void getMsgInfo(Message<String> msgs){
        System.out.println("消费者："+portInfo+",接受到的消息为===="+msgs.getPayload());
    }
}
