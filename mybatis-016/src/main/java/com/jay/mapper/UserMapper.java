package com.jay.mapper;

import com.jay.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.Map;

/**
 * @author xuweijie
 */
public interface UserMapper {

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findById(Long id);

    @Select("select * from user where name = #{param1} and password = #{param2}")
    @Results({ // 结果映射
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password")
    })
    User findByNameAndPasswordV1(String name, String password);

    User findByNameAndPasswordV2(@Param("username") String name, @Param("password") String password);

    @Select("select * from user where name = #{username} and password = #{password}")
    User findByNameAndPasswordV3(Map<String, Object> data);

    @Select("select * from user where name = #{param1.username} and password = #{param2};")
    User findByNameAndPasswordV4(Map<String, Object> data, String password);

    @Select("select * from user where name = #{data.username} and password = #{password};")
    User findByNameAndPasswordV5(@Param("data") Map<String, Object> data, @Param("password") String password);

    @Select("select * from user where name = #{name} and password = ${password}")
    User findByNameAndPasswordV6(User user);

    @Select("select * from blog_db.user where name=#{user.name} and password=#{user.password}")
    User findByNameAndPasswordV7(@Param("user") User user);

    /**
     * 插入用户
     *
     * @param user
     * @return 影响的行数
     */
    @Insert("insert into user (name, email, password) values (#{name}, #{email}, #{password} );")
    @Options(useGeneratedKeys = true, keyProperty = "id") // 自动生成主键值，赋值给id字段
    int insertUser(User user);

}
