package com.jay;

import com.jay.bean.Blog;
import com.jay.bean.User;
import com.jay.mapper.BlogMapper;
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
        test03();
    }

    private static void test03() throws IOException {
        try (SqlSession sqlSession = getSqlSession()) {
            BlogMapper userMapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = userMapper.findById(1L);
            log.info("{}", blog);
        }
    }

    private static void test02() throws IOException {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = userMapper.findByPassword("123");
            users.forEach(user -> {
                log.info("{}", user);
            });
        }
    }

    private static void test01() throws IOException {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.findById(1L);
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
