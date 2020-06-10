package com.home.springcloud.repository;

import com.home.springcloud.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author：tongrongbing
 * @date：created in 2020/5/17 22:05
 * @description：
 */
public interface DeptRepository extends JpaRepository<Dept,Long> {
}
