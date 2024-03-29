package com.home.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

/**
 * @author：tongrongbing
 * @date：created in 2020/5/17 21:37
 * @description：
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptProviderHystrixDashBoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrixDashBoardApplication.class,args);
    }


}