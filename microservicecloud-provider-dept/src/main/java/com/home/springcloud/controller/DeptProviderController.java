package com.home.springcloud.controller;

import com.home.springcloud.entity.Dept;
import com.home.springcloud.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author：tongrongbing
 * @date：created in 2020/5/17 22:24
 * @description：
 */
@RestController
@Slf4j
public class DeptProviderController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    public Object findById(@PathVariable("id") Long id){
        Dept dept = deptService.findById(id);
        log.info("【获取数据】,deptList={}",dept);
        return dept;
    }

    @GetMapping("/dept/list")
    public Object findAll(){
        List<Dept> deptList = deptService.findAll();
        log.info("【获取数据】,deptList={}",deptList);
        return deptList;
    }

    @GetMapping("/msg")
    public String get(){
        return "hello";
    }
}