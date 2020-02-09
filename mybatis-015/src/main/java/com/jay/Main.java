package com.jay;

import com.jay.bean.Blog;
import com.jay.mapper.BlogMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
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
        // 使用PageHelper进行分页查询
        try (SqlSession sqlSession = getSqlSessionWithPageHelperPluginInConfigXml()) {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            List<Blog> blogList = blogMapper.findByUserIdWithRowBounds(1L, new RowBounds(0, 2));
            blogList.forEach(item -> {
                log.info("blog: {}", item);
            });
        }
    }

    private static void test02() throws IOException {
        try (SqlSession sqlSession = getSqlSession()) {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            List<Blog> blogs = blogMapper.findByUserIdWithRowBounds(1L, new RowBounds(0, 2));
            blogs.forEach(blog -> {
                log.info("{}", blog);
            });
        }
    }

    private static void test01() throws IOException {
        try (SqlSession sqlSession = getSqlSession()) {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            List<Blog> blogs = blogMapper.findByUserId(1L, 0, 2);
            blogs.forEach(blog -> {
                log.info("{}", blog);
            });
        }
    }

    private static SqlSession getSqlSession() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder
                .build(Resources.getResourceAsReader("mybatis-config.xml"), "development");
        return sqlSessionFactory.openSession();
    }

    private static SqlSession getSqlSessionWithPageHelperPluginInConfigXml() throws IOException {
        SqlSessionFactory sessionFactory;
        sessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsReader("mybatis-config-with-pagehelper.xml"));
        return sessionFactory.openSession();
    }

}
