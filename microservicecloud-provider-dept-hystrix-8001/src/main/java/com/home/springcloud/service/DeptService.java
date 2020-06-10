package com.home.springcloud.service;

import com.home.springcloud.entity.Dept;

import java.util.List;

/**
 * @author：tongrongbing
 * @date：created in 2020/5/17 22:14
 * @description：
 */
public interface DeptService {
    List<Dept> findAll();
    Dept findById(Long id);
}
