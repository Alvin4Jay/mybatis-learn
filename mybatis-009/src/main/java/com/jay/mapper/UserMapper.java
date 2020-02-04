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

    /**
     * 添加用户
     *
     * @param user
     * @return 影响的行数
     */
    int insertUser(User user);

    /**
     * 根据 id 更新密码
     *
     * @return 影响的行数
     */
    int updateUserPasswordById(User user);

    /**
     * 删除指定id的记录
     *
     * @param id
     * @return 影响的行数
     */
    int deleteById(Long id);

    /**
     * 删除id在 [minId, maxId] 范围内的记录
     * @param minId
     * @param maxId
     * @return 影响的行数
     */
    int deleteByIdRange(Long minId, Long maxId);
}
