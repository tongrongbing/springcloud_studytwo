package com.home.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author：tongrongbing
 * @date：created in 2020/5/17 21:37
 * @description：
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DeptProvider8001Application {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001Application.class,args);
    }
}