package com.xcx.springcloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Auther: 自定义网关过滤器
 * @Date: 2020/4/22 12:58
 * @Description:
 */
@Component
@Slf4j
public class MyGatewayFilter implements GlobalFilter,Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*****全局自定义过滤器****");
        //获取reqeust对象
        ServerHttpRequest request = exchange.getRequest();
        //获取所有参数
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        //获取指定参数
        String username = queryParams.getFirst("username");
        //比如这里判断如果username为null返回
        if(username==null){
            System.out.println("。。。。参数为null。。。。");
            //返回响应
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * 加载过滤器的顺序，值越小越高
     * @param: 
     * @return: 
     * @auther: 肖朝翔
     * @date: 2020/4/22 13:00
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
