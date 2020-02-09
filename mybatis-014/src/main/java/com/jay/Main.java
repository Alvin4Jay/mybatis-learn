package com.jay;

import com.jay.mapper.StudentMapper;
import com.jay.mapper.TeacherMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * 多对多测试
 *
 * @author xuweijie
 */
@Slf4j
public class Main {

    public static void main(String[] args) throws IOException {
        test01();
        // test02();
    }

    private static void test02() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder
                .build(Resources.getResourceAsReader("mybatis-config.xml"), "development");

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            log.info("{}", teacherMapper.findById(1L));
        }
    }

    private static void test01() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder
                .build(Resources.getResourceAsReader("mybatis-config.xml"), "development");

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            log.info("{}", studentMapper.findById(1L));
            log.info("{}", studentMapper.findById(2L));
        }
    }

}
