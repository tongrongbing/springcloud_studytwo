package com.home.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


/**
 * @author：tongrongbing
 * @date：created in 2020/5/17 22:59
 * @description：
 */
@SpringBootApplication
@EnableConfigServer
public class MicroserviceConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConfigApplication.class,args);
    }
}