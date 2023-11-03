package com.jay.mybatis.spring.boot;

import com.jay.mybatis.spring.boot.bean.User;
import com.jay.mybatis.spring.boot.config.InitConfig;
import com.jay.mybatis.spring.boot.mapper.FortypeMapper;
import com.jay.mybatis.spring.boot.mapper.UserTestMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Import(InitConfig.class)
public class Boot implements CommandLineRunner {

    @Resource
    UserTestMapper userTestMapper;

    @Resource
    FortypeMapper fortypeMapper;

    @Resource
    SqlSession sqlSession;

    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }

    @Override
    @Transactional(timeout = 1) // 事务管理测试
    public void run(String... strings) throws InterruptedException {
//        Thread.sleep(10000);
        // 使用SqlSession
//        System.out.println(
//                (User)sqlSession.selectOne("com.jay.mybatis.spring.boot.mapper.UserMapper.findById", 1L));
        // 使用Mapper
        System.err.println(userTestMapper.findByName("aaa", true));


//        Fortype fortype = new Fortype();
//        fortype.setId(3L);
//        fortype.setDetail("dsdsddddddd");
//        System.err.println(fortypeMapper.insert(fortype));

        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setId(12L);
        user1.setName("eeee");
//        user1.setEmail("cccc@qq");
//        user1.setPassword("cccccc");

        User user2 = new User();
        user2.setId(17L);
        user2.setName("ffff");
//        user2.setEmail("dddd@qq");
//        user2.setPassword("ddddd");

        userList.add(user1);
        userList.add(user2);

        System.err.println("插入返回值：" + userTestMapper.batchInsert(userList));
    }
}
