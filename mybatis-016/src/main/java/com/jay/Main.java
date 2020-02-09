package com.jay;

import com.jay.bean.User;
import com.jay.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuweijie
 */
@Slf4j
public class Main {

    public static void main(String[] args) throws IOException {
        // test01();
        // test02();
        // test03();
        // test04();
        // test05();
        // test06();
        // test07();
        // test08();
        test09();
    }

    private static void test01() throws IOException {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.findById(1L);
            log.info("{}", user);
        }
    }

    private static void test02() throws IOException {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.findByNameAndPasswordV1("letian", "123");
            log.info("{}", user);
        }
    }

    private static void test03() throws IOException {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.findByNameAndPasswordV2("letian", "123");
            log.info("{}", user);
        }
    }

    private static void test04() throws IOException {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> data = new HashMap<>();
            data.put("username", "letian");
            data.put("password", "123");
            User user = userMapper.findByNameAndPasswordV3(data);
            log.info("{}", user);
        }
    }

    private static void test05() throws IOException {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> data = new HashMap<>();
            data.put("username", "letian");
            User user = userMapper.findByNameAndPasswordV4(data, "123");
            log.info("{}", user);
        }
    }

    private static void test06() throws IOException {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> data = new HashMap<>();
            data.put("username", "letian");
            User user = userMapper.findByNameAndPasswordV5(data, "123");
            log.info("{}", user);
        }
    }

    private static void test07() throws IOException {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setName("letian");
            user.setPassword("123");
            user = userMapper.findByNameAndPasswordV6(user);
            log.info("{}", user);
        }
    }

    private static void test08() throws IOException {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setName("letian");
            user.setPassword("123");
            user = userMapper.findByNameAndPasswordV7(user);
            log.info("{}", user);
        }
    }

    private static void test09() throws IOException {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            User user = new User();
            user.setName("zhangsan");
            user.setEmail("zhangsan@qq.com");
            user.setPassword("456");

            int result = userMapper.insertUser(user);
            sqlSession.commit(); // 提交事务
            log.info("result: {}", result);
        }
    }

    private static SqlSession getSqlSession() throws IOException {
        SqlSessionFactory sessionFactory;
        sessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsReader("mybatis-config.xml"));
        return sessionFactory.openSession();
    }

}
