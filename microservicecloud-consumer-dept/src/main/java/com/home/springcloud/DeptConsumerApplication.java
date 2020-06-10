package com.home.springcloud;

import com.home.springcloud.config.MyIRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author：tongrongbing
 * @date：created in 2020/5/17 22:59
 * @description：
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name="MICROSERVICELOUD-DEPT",configuration = MyIRule.class)
public class DeptConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerApplication.class,args);
    }
}