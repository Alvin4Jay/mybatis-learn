package com.jay.mapper;

import com.jay.bean.User;
import org.apache.ibatis.annotations.Param;

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
    User findById(@Param("id") Long id);

}
