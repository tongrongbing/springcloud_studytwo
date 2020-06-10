package com.home.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author：tongrongbing
 * @date：created in 2020/5/17 22:59
 * @description：
 * @EnableFeignClients(basePackages = "com.home.springcloud") 因为feign的接口定义在一个公用的模块
 * 因此需要在@EnableFeignClients注解上指定扫描feign接口定义。在接口DeptFeignServiceClient定义中
 * 使用@FeignClient(value = "MICROSERVICELOUD-DEPT")定义了微服务的名称，用于用于服务发现。
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.home.springcloud")
public class DeptFeignConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptFeignConsumerApplication.class,args);
    }
}