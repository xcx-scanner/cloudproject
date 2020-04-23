package com.xcx.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/4/23 13:01
 * @Description:
 */
@RestController
//RefreshScope,配置文件修改后，配置客户端不需要重启即可动态获取到，不需要重启
//RefreshScope该注解还需要配置文件中配置暴露监听端口
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;
    @Value("${server.port}")
    private String portInfo;

    /**
     * 测试获取配置信息
     * @param: 
     * @return: 
     * @auther: 肖朝翔
     * @date: 2020/4/23 13:03
     */
    @GetMapping(value = "/queryInfo")
    public String queryInfo(){
          return configInfo+":"+portInfo;
    }
}
