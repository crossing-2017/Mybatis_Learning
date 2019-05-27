package com.crossing.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 连接数据库的实体类
 * @author Crossing
 * @date 2019-05-26
 */
@Data
public class User implements Serializable {

    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

}
