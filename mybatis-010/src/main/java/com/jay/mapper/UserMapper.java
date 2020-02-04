package com.jay.mapper;

import com.jay.bean.User;

/**
 * @author xuweijie
 */
public interface UserMapper {

    /**
     * 根据 id 更新密码
     *
     * @return 影响的行数
     */
    int updateUserPasswordById(User user);

}
