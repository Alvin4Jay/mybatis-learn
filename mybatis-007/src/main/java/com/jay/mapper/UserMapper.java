package com.jay.mapper;

import com.jay.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xuweijie
 */
public interface UserMapper {

    /**
     * 根据密码查询所有用户
     *
     * @param password
     * @param orderClause
     * @return
     */
    List<User> findByPassword(@Param("password") String password, @Param("orderClause") String orderClause);

}
