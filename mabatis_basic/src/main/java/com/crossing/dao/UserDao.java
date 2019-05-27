package com.crossing.dao;

import com.crossing.domain.QueryVo;
import com.crossing.domain.User;
import org.apache.ibatis.annotations.Select;

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
     * 对象存入数据库
     * @param user
     */
   public void saveUser(User user);

    /**
     * 更新用户信息
     * @param user
     */
   public void updateUser(User user);

    /**
     * 根据id删除用户
     * @param userId
     */
   public void deleteUser(Integer userId);


    /**
     * 根据ID返回用户信息
     * @param userId
     * @return
     */
   public User findOneUser(Integer userId);


    /**
     * 根据名称模糊查询用户信息
     * @param username
     * @return
     */
    List<User> findByName(String username);


    /**
     * 获取数据总条数
     */
    public Integer findTotal();


    /**
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);


    /**
     * 根据传入参数条件
     * @param user 查询的条件：有可能有用户名，有可能有性别，也有可能有地址，还有可能是都有
     * @return
     */
    public List<User> findByCondition(User user);


    /**
     * 根据queryvo中提供的id集合，查询用户信息
     * @param queryVo
     * @return
     */
    public List<User> findUsersInIds(QueryVo queryVo);
}
