package com.crossing.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * account实体类
 * @author Crossing
 * @date 2019-05-27
 */
@Data
public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private Double money;
}
