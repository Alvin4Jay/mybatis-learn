package com.jay.datasource.mapper;

import com.jay.User;

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
