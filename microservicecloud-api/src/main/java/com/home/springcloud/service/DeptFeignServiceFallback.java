package com.home.springcloud.service;

import com.home.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author：tongrongbing
 * @date：created in 2020/6/9 23:47
 * @description：
 */
@Component
public class DeptFeignServiceFallback implements FallbackFactory<DeptFeignServiceClient> {
    @Override
    public DeptFeignServiceClient create(Throwable cause) {
        return new DeptFeignServiceClient(){
            @Override
            public List<Dept> findAll() {
                return null;
            }

            @Override
            public Dept findById(Long id) {
                Dept dept = new Dept();
                dept.setDeptName(id+"部门不存在啊啊啊啊啊啊啊........");
                return dept;
            }
        };
    }
}