package com.home.springcloud.service.impl;

import com.home.springcloud.entity.Dept;
import com.home.springcloud.repository.DeptRepository;
import com.home.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author：tongrongbing
 * @date：created in 2020/5/17 22:26
 * @description：
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptRepository deptRepository;

    @Override
    public List<Dept> findAll() {
        return deptRepository.findAll();
    }

    @Override
    public Dept findById(Long id) {
        return deptRepository.findById(id).get();
    }
}