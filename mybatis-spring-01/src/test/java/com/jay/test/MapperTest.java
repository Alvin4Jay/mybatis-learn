package com.jay.test;

import com.jay.config.MyBatisConfig;
import com.jay.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xuweijie
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyBatisConfig.class})
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SqlSession sqlSession;

    @Test
    @Transactional
    public void test01() {
        System.out.println(userMapper.findById(1L));
    }

    @Test
    public void test02() {
        System.out.println(userMapper.findById(1L));
    }

}
