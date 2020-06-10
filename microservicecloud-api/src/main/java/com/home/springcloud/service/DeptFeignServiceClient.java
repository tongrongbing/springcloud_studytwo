package com.home.springcloud.service;

import com.home.springcloud.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author：tongrongbing
 * @date：created in 2020/6/9 19:39
 * @description：
 */
//valeu:定义了微服务的名称，用于用于服务发现。fallback:定义服务熔断处理
@FeignClient(value = "MICROSERVICELOUD-DEPT",fallbackFactory = DeptFeignServiceFallback.class)
public interface DeptFeignServiceClient {

    @GetMapping("/dept/list")
    List<Dept> findAll();

    @GetMapping("/dept/get/{id}")
    Dept findById(@PathVariable("id") Long id);
}
