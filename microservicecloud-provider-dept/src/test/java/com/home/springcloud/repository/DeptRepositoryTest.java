package com.home.springcloud.repository;

import com.home.springcloud.entity.Dept;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * @author：tongrongbing
 * @date：created in 2020/5/17 22:15
 * @description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptRepositoryTest {

    @Autowired
    private DeptRepository deptRepository;
    @Test
    public void findAll(){
        List<Dept> deptList = deptRepository.findAll();
        Assert.assertTrue(deptList.size() > 0);
    }

    @Test
    public void findById(){
        Optional<Dept> deptOptional = deptRepository.findById(1L);
        boolean present = deptOptional.isPresent();
        Assert.assertTrue(present);
    }
}