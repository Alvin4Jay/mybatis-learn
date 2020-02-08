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

    List<User> findByPassword(String password);

}
