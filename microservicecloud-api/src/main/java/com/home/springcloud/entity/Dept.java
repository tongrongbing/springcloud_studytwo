package com.home.springcloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author：tongrongbing
 * @date：created in 2020/5/17 21:14
 * @description：
 */
@Data
@NoArgsConstructor
@Entity
public class Dept implements Serializable {
    @Id
    private Long deptNo;
    private String deptName;
    private String dbSource;

}