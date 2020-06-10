package com.home.springcloud.controller;

import com.home.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author：tongrongbing
 * @date：created in 2020/5/17 22:51
 * @description：
 */
@RestController
@RequestMapping("/consumer")
public class DeptConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/dept/{id}")
    public Object getDept(@PathVariable("id") Long id){
       // Dept dept = restTemplate.getForObject("http://localhost:8081/dept/get/" + id, Dept.class);
        Dept dept = restTemplate.getForObject("http://MICROSERVICELOUD-DEPT/dept/get/" + id, Dept.class);
        return dept;
    }

    @GetMapping("/get")
    public String getMsg(){
        String res = restTemplate.getForObject("http://MICROSERVICELOUD-DEPT/msg", String.class);
        return res;
    }
}