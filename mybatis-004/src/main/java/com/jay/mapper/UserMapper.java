package com.jay.mapper;

import com.jay.bean.User;

import java.util.List;

/**
 * @author xuweijie
 */
public interface UserMapper {

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     * 根据密码，查询一个用户.
     * 必须保证最多返回一条数据，否则会报 TooManyResultsException 错误。无数据，则返回null
     *
     * @param password
     * @return
     */
    User findOneUserByPassword(String password);

    /**
     * 根据密码，查询所有用户
     *
     * @param password
     * @return
     */
    List<User> findByPassword(String password);

}
