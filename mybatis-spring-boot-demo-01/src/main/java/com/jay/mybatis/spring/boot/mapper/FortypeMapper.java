package com.jay.mybatis.spring.boot.mapper;

import com.jay.mybatis.spring.boot.bean.Fortype;
import com.jay.mybatis.spring.boot.bean.User;
import com.jay.mybatis.spring.boot.interfaces.DtoToSqlInterface;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xuweijie
 */
@Mapper
public interface FortypeMapper {

    int insert(@Param("item") Fortype fortype);

}
