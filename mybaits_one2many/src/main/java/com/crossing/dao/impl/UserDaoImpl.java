package com.crossing.dao.impl;

import com.crossing.dao.UserDao;
import com.crossing.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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

    public User findOneUser(Integer userId) {
        return null;
    }


}
