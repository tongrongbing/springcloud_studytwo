package com.home.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author：tongrongbing
 * @date：created in 2020/5/17 23:30
 * @description：
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer03Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer03Application.class,args);
    }
}