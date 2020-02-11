package com.jay.mybatis.spring.boot;

import com.jay.mybatis.spring.boot.bean.User;
import com.jay.mybatis.spring.boot.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class Boot implements CommandLineRunner {

    @Resource
    UserMapper userMapper;

    @Resource
    SqlSession sqlSession;

    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }

    @Override
    public void run(String... strings) {
        // 使用SqlSession
        System.out.println(
                (User)sqlSession.selectOne("com.jay.mybatis.spring.boot.mapper.UserMapper.findById", 1L));
        // 使用Mapper
        System.err.println(userMapper.findById(1L));
    }
}
