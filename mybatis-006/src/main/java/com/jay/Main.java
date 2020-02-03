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
        test01();
    }

    private static void test01() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder
                .build(Resources.getResourceAsReader("mybatis-config.xml"), "development");
        // environment这个参数可以省略，因为 mybatis-config.xml 的<environments>标签指定了默认环境为development

        // 以上是样板代码
        // 以下是「业务逻辑」
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //User user = userMapper.findById(1L);
            //User user = userMapper.findByNameAndPasswordV1("letian", "123");
            //User user = userMapper.findByNameAndPasswordV2("letian", "123");

            //Map<String, Object> data = new HashMap<>();
            //data.put("username", "letian");
            //data.put("password", "123");
            //User user = userMapper.findByNameAndPasswordV3(data);

            //Map<String, Object> data = new HashMap<>();
            //data.put("username", "letian");
            //User user = userMapper.findByNameAndPasswordV4(data, "123");

            //Map<String, Object> data = new HashMap<>();
            //data.put("username", "letian");
            //User user = userMapper.findByNameAndPasswordV5(data, "123");

            User user = new User();
            user.setName("letian");
            user.setPassword("123");
            //user = userMapper.findByNameAndPasswordV6(user);
            user = userMapper.findByNameAndPasswordV7(user);

            log.info("{}", user);
        }
    }

}
