package com.home.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * @author：tongrongbing
 * @date：created in 2020/5/17 21:37
 * @description：
 */
@SpringBootApplication
@EnableDiscoveryClient // 用于服务发现
@EnableCircuitBreaker //用于对Hystrix熔断机制的支持
public class DeptProviderHystrix8001Application {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix8001Application.class,args);
    }

}