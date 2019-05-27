package com.crossing.test;

import com.crossing.dao.UserDao;
import com.crossing.dao.impl.UserDaoImpl;
import com.crossing.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Mybatis的测试案例
 * @author Crossing
 * @date 2019-05-26
 */
public class MybatisTest {

    Reader reader;
    SqlSession session;
    UserDao userDao;

    /**
     * //用于在测试方法执行之前执行
     * @throws IOException
     */
    @Before
    public void init() throws IOException {
        //1.读取配置文件
        reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(reader);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);
        //4.使用SqlSession创建Dao接口的代理对象
        userDao = session.getMapper(UserDao.class);
    }

    /**
     * 用于在测试方法执行之后执行
     * @throws IOException
     */
    @After
    public void destroy() throws IOException {

        //提交事务
        //session.commit();
        //6.释放资源
        session.close();
        if(reader != null) {
            reader.close();
        }
    }

    /**
     * 测试查询所有
     */
    @Test
    public void test01(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }


    /**
     * 使用实现类实现
     */
    @Test
    public void test02() throws IOException {
        //1.读取配置文件
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(reader);
        //3.使用工厂生产SqlSession对象
        UserDao userDao = new  UserDaoImpl(factory);
        //4.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //5.释放资源
        reader.close();
    }

    /**
     * 测试保存对象
     */
    @Test
    public void test03(){
        User user = new User();
        user.setUsername("autocommit");
        user.setAddress("杭州");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前的user信息" + user);
        userDao.saveUser(user);
        System.out.println("保存操作之后的user信息" + user);
    }

    /**
     * 更新用户
     */
    @Test
    public void test04(){
        User user = new User();
        user.setId(50);
        user.setUsername("mybatis username");
        user.setAddress("北京");
        user.setSex("女");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }


    /**
     * 删除用户
     */
    @Test
    public void test05(){
        userDao.deleteUser(48);
    }

    /**
     * 根据id返回用户数据
     */
    @Test
    public void test06(){
        User oneUser = userDao.findOneUser(51);
        System.out.println(oneUser);
    }

    /**
     * 根据姓名模糊查询数据
     */
    @Test
    public void test07(){
//        List<User> elements = userDao.findByName("%王%");
        List<User> elements = userDao.findByName("王");

        for (User element : elements) {
            System.out.println(element);
        }
    }

    /**
     * 查询记录总条数
     */
    @Test
    public void test08(){
        Integer total = userDao.findTotal();
        System.out.println(total);


    }

    /**
     * 测试使用QueryVo作为查询条件
     */
    @Test
    public void test09(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        //5.执行查询一个方法
        List<User> users = userDao.findUserByVo(vo);
        for(User u : users){
            System.out.println(u);
        }
    }


    /**
     * 根据条件查询
     */
    @Test
    public void test10(){
        User u = new User();
        u.setUsername("老王");
        u.setSex("女");
        List<User> users = this.userDao.findByCondition(u);
        for (User user : users) {
            System.out.println(user);
        }
    }


    /**
     * 测试foreach标签的使用
     */
    @Test
    public void test11 (){
        QueryVo queryVo = new QueryVo();

        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(42);
        ids.add(43);
        queryVo.setIds(ids);


        List<User> users = userDao.findUsersInIds(queryVo);
        for (User user : users) {
            System.out.println(user);
        }
    }

}
