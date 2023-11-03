package com.jay.mybatis.spring.boot.config;

import com.jay.mybatis.spring.boot.listener.MapperInit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * desc.
 *
 * @author zhongshuo.xwj
 */
@Configuration
public class InitConfig {

    @Bean
    public MapperInit mapperInit() {
        return new MapperInit();
    }

}
