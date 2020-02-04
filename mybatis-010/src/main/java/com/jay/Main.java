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
        // test01();
        // test02();
        // test03();
        test04();
    }

    private static void test04() throws IOException {
        try (SqlSession sqlSession = getSqlSession(false)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setId(2L);
            user.setPassword("456789");
            int result = userMapper.updateUserPasswordById(user);
            log.info("result: {}, user: {}", result, user);
            sqlSession.commit(true); // 强制提交事务
        }
    }

    private static void test03() throws IOException {
        try (SqlSession sqlSession = getSqlSession(false)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setId(2L);
            user.setPassword("123456");
            int result = userMapper.updateUserPasswordById(user);
            log.info("result: {}, user: {}", result, user);
            sqlSession.commit(); // 提交事务
        }
    }

    private static void test02() throws IOException {
        try (SqlSession sqlSession = getSqlSession(false)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setId(2L);
            user.setPassword("123456");
            int result = userMapper.updateUserPasswordById(user);
            log.info("result: {}, user: {}", result, user);
            sqlSession.rollback(true); // 强制回滚
        }
    }

    private static void test01() throws IOException {
        try (SqlSession sqlSession = getSqlSession(false)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setId(2L);
            user.setPassword("123456");
            int result = userMapper.updateUserPasswordById(user);
            log.info("result: {}, user: {}", result, user);
            sqlSession.rollback(); // 回滚。若之前没有insert、delete、update，则不进行回滚
        }
    }

    private static SqlSession getSqlSession(boolean autoCommit) throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder
                .build(Resources.getResourceAsReader("mybatis-config.xml"), "development");
        return sqlSessionFactory.openSession(autoCommit);
    }
}
