package com.jay.mybatis.spring.boot.mapper;

import com.jay.mybatis.spring.boot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xuweijie
 */
@Mapper
public interface UserMapper {

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    User findById(@Param("id") Long id);

}
