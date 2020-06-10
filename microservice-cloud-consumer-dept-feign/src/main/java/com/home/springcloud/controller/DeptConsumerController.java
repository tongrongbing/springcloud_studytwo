package com.home.springcloud.controller;

import com.home.springcloud.entity.Dept;
import com.home.springcloud.service.DeptFeignServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：tongrongbing
 * @date：created in 2020/5/17 22:51
 * @description：
 */
@RestController
@RequestMapping("/consumer")
public class DeptConsumerController {

    @Autowired
    private DeptFeignServiceClient serviceClient;

    @GetMapping("/dept/{id}")
    public Object getDept(@PathVariable("id") Long id){
        return serviceClient.findById(id);
    }

}