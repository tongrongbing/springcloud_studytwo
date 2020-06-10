package com.home.springcloud.controller;

import com.home.springcloud.entity.Dept;
import com.home.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "getByIdFallback")
    public Object findById(@PathVariable("id") Long id){
        Dept dept = deptService.findById(id);
        log.info("【获取数据】,deptList={}",dept);
        if(dept == null){
            throw new RuntimeException();
        }
        return dept;
    }

    @GetMapping("/dept/list")
    public Object findAll(){
        List<Dept> deptList = deptService.findAll();
        log.info("【获取数据】,deptList={}",deptList);
        return deptList;
    }

    /**
     * @author: tongrongbing   hystrix的默认回调方法必须与原方法结构一样。包括参数和返回类型
     * @description: Also a fallback method should have same signature to a method which was invoked as hystrix command.
     * @time: 2020/6/9 22:08
     * @param id
     * @return java.lang.Object
     */
    private Object getByIdFallback(@PathVariable("id") Long id){
        Dept dept = new Dept();
        dept.setDeptName(id+"不存在");
        return dept;
    }

    @GetMapping("/msg")
    public String get(){
        return "hello";
    }
}