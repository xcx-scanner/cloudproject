package com.xcx.springcloud.service.impl;

import com.xcx.springcloud.service.MsgStreamInfo;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;


import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/4/23 21:37
 * @Description:
 */
@EnableBinding(Source.class) //定义消息的推送管道
public class MsgStreamInfoImpl implements MsgStreamInfo {
    @Resource
    private MessageChannel output; //消息发送管道

    @Override
    public String sendMsg() {
        String msg="cloud stream to rabbitmq"+UUID.randomUUID();
        output.send(MessageBuilder.withPayload(msg).build());
        System.out.println("send msg:"+msg);
        return msg;
    }
}
