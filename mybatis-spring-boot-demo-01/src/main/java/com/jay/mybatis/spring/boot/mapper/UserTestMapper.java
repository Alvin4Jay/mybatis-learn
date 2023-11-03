package com.jay.mybatis.spring.boot.mapper;

import com.jay.mybatis.spring.boot.bean.User;
import com.jay.mybatis.spring.boot.interfaces.DtoToSqlInterface;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xuweijie
 */
@Mapper
public interface UserTestMapper extends DtoToSqlInterface {

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    List<User> findByName(@Param("name") String name, @Param("orderByIdDesc") Boolean orderByIdDesc);

    int batchInsert(@Param("list") List<User> users);

}
