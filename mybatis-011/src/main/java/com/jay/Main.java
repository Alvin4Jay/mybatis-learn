package com.jay;

import com.jay.bean.User;
import com.jay.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @author xuweijie
 */
@Slf4j
public class Main {

    public static void main(String[] args) throws IOException {
        // test01();
        // test02();
        // test03();
        test04();
    }

    public static void test03() throws IOException {
        try (SqlSession sqlSession = getSqlSession()) {
            User queryCondition = new User();
            queryCondition.setId(1L);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.find(queryCondition);
            log.info("{}", userList);
        }
    }

    public static void test04() throws IOException {
        try (SqlSession sqlSession = getSqlSession()) {
            User queryCondition = new User();
            queryCondition.setPassword("123");
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.find(queryCondition);
            log.info("{}", userList);
        }
    }

    private static void test02() throws IOException {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.findByName("letian", "1234");
            log.info("{}", user);
        }
    }

    private static void test01() throws IOException {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.findByName("letian", null);
            log.info("{}", user);
        }
    }

    private static SqlSession getSqlSession() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder
                .build(Resources.getResourceAsReader("mybatis-config.xml"), "development");
        return sqlSessionFactory.openSession();
    }
}
