package com.jay.mybatis.spring.boot.listener;

import com.google.common.base.CaseFormat;
import com.jay.mybatis.spring.boot.interfaces.DtoToSqlInterface;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Map;

/**
 * @Author hongwei
 * @Date 2018/12/27
 */
public class MapperInit implements ApplicationListener<ContextRefreshedEvent> {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MapperInit.class);
    @Autowired
    private ConfigurableApplicationContext context;

    public static final  String DEFAULT_SUFFIX = "Mapper";

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        if (event.getApplicationContext().getParent() == null) {
            Map<String, DtoToSqlInterface> mapperBeans= context.getBeansOfType(DtoToSqlInterface.class);
            mapperBeans.forEach((k,v)->{
                String key = k.substring(0,k.length() - DEFAULT_SUFFIX.length());
                String  tableName= CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,key);
                logger.info("DtoToSqlInterface: {}", tableName);
            });
        }
    }
}
