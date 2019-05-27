package com.crossing.dao;

import com.crossing.domain.Account;

import java.util.List;

/**
 * Account数据库接口
 * @author Crossing
 * @date 2019-05-27
 */
public interface AccountDao {

    /**
     * 查询所有账户，同时还要获取到当前账户的所属用户信息
     * @return
     */
    public List<Account> findAll();

}
