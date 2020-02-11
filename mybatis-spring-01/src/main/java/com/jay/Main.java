package com.jay;

import com.jay.config.MyBatisConfig;
import com.jay.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xuweijie
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyBatisConfig.class);

        UserMapper userMapper = context.getBean(UserMapper.class);

        log.info("{}", userMapper.findById(1L));
    }


}
