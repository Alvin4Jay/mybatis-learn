package com.jay.mapper;

import com.jay.bean.User;

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
}
