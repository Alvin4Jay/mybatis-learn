package com.jay;

import com.jay.bean.User;
import com.jay.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author xuweijie
 */
@Slf4j
public class Main {

    public static void main(String[] args) throws IOException {
        // test_insertUser();
        // test_updateUserPasswordById();
        // test_deleteById();
        test_deleteByIdRange();
    }

    private static void test_deleteByIdRange() throws IOException {
        try (SqlSession sqlSession = getSqlSession(false)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int result = userMapper.deleteByIdRange(1L, 2L);
            log.info("result: {}", result);
            sqlSession.commit();
        }
    }

    private static void test_deleteById() throws IOException {
        try (SqlSession sqlSession = getSqlSession(false)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int result = userMapper.deleteById(3L);
            log.info("result: {}", result);
            sqlSession.commit();
        }
    }

    private static void test_updateUserPasswordById() throws IOException {
        try (SqlSession sqlSession = getSqlSession(false)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setId(3L);
            user.setPassword("123456");
            int result = userMapper.updateUserPasswordById(user);
            log.info("result: {}, user: {}", result, user);
            sqlSession.commit();
        }
    }

    private static void test_insertUser() throws IOException {
        try (SqlSession sqlSession = getSqlSession(false)) { // 手动提交事务
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setName("xiaowei");
            user.setEmail("xiaowei@111.com");
            user.setPassword("456");

            int result = userMapper.insertUser(user);
            log.info("result: {}, user: {}", result, user);
            sqlSession.commit(); // 事务提交
        }
    }

    private static SqlSession getSqlSession(boolean autoCommit) throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder
                .build(Resources.getResourceAsReader("mybatis-config.xml"), "development");
        return sqlSessionFactory.openSession(autoCommit);
    }

}
