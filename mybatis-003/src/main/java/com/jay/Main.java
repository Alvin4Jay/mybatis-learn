package com.jay;

import com.jay.bean.User;
import com.jay.datasource.DBCPDataSource;
import com.jay.datasource.MyBatisDataSource;
import com.jay.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

/**
 * @author xuweijie
 */
@Slf4j
public class Main {

    private static void test01() {
        DataSource dataSource = MyBatisDataSource.get();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(UserMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.findById(1L);
            log.info("{}", user);
        }
    }

    private static void test02() {
        DataSource dataSource = DBCPDataSource.get();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(UserMapper.class);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        SqlSession sqlSession = sessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.findById(1L);
            log.info("{}", user);
        } finally {
            sqlSession.close();
        }
    }

    public static void main(String[] args) {
        // test01();
        test02();
    }

}
