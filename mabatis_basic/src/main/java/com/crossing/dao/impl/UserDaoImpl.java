package com.crossing.dao.impl;

import com.crossing.dao.UserDao;
import com.crossing.domain.QueryVo;
import com.crossing.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

/**
 * 用户持久成实现类
 * @author Crossing
 * @date 2019-05-26
 */
public class UserDaoImpl implements UserDao {
    SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    public List<User> findAll() {
        //1.创建sqlSession对象
        SqlSession session = factory.openSession();
        //2.使用Sqlsession执行查询方法
        List<User> users = session.selectList("com.crossing.dao.UserDao.findAll");
        session.close();
        //3.返回查询结果
        return users;
    }

    public void saveUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(Integer userId) {

    }

    public User findOneUser(Integer userId) {
        return null;
    }

    public List<User> findByName(String username) {
        return null;
    }

    public Integer findTotal() {
        return null;
    }

    public List<User> findUserByVo(QueryVo vo) {
        return null;
    }

    public List<User> findByCondition(User user) {
        return null;
    }

    public List<User> findUsersInIds(QueryVo queryVo) {
        return null;
    }
}
