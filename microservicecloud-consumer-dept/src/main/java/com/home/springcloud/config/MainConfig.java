package com.home.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author：tongrongbing
 * @date：created in 2020/5/17 22:48
 * @description：
 */
@Configuration
public class MainConfig {

    @Bean
    @LoadBalanced  // 使用该注解实现ribbon的客户端的负载均衡,客户端的负载均衡工具
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

   /* @Bean
    public IRule myRule(){
        return new RandomRule();   // 自定义负载均衡算法，用随机算法来替换Ribbon默认的轮询算法
    }*/
}