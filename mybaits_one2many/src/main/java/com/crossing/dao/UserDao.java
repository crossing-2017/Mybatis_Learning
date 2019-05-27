package com.crossing.dao;

import com.crossing.domain.User;

import java.util.List;

/**
 * 连接数据库接口，用户持久层方法
 * @author Crossing
 * @date 2019-05-26
 *
 */
public interface UserDao {

    /**
     * 查询数据库所有数据
     * @return
     */
   public List<User> findAll();

    /**
     * 根据ID返回用户信息
     * @param userId
     * @return
     */
   public User findOneUser(Integer userId);

}
