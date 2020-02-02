package com.jay.datasource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

import javax.sql.DataSource;

/**
 * @author xuweijie
 */
public class MyBatisDataSource {

    public static DataSource get() {
        PooledDataSource dataSource = new PooledDataSource();

        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/blog_db?useUnicode=true&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setPoolMaximumActiveConnections(100);
        dataSource.setPoolMaximumIdleConnections(8);

        return dataSource;
    }

}
