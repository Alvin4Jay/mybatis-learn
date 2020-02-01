package com.jay.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
 * JDBC示例
 *
 * @author xuweijie
 */
@Slf4j
public class JDBCDemo {

    private static void test01() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/blog_db?useUnicode=true&amp;characterEncoding=utf8",
                "root",
                "123456");

        Statement stmt = conn.createStatement();
        String sql = "SELECT id, name, email, password FROM user WHERE id = 1";
        ResultSet rs = stmt.executeQuery(sql);

        // 读取数据
        while (rs.next()) {
            log.info("id: {}", rs.getLong("id"));
            log.info("name: {}", rs.getString("name"));
            log.info("email: {}", rs.getString("email"));
            log.info("password: {}", rs.getString("password"));
        }

        // 关闭资源
        rs.close();
        stmt.close();
        conn.close();
    }

    private static void test02() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/blog_db?useUnicode=true&amp;characterEncoding=utf8",
                "root",
                "123456");

        PreparedStatement stmt = conn.prepareStatement("SELECT id, name, email, password FROM user WHERE id = ?");
        // 第1个参数代表对应sql的第几个问号，第2个参数代表对应的值
        stmt.setInt(1, 1);
        ResultSet rs = stmt.executeQuery();
        // 读取数据
        while (rs.next()) {
            log.info("id: {}", rs.getLong("id"));
            log.info("name: {}", rs.getString("name"));
            log.info("email: {}", rs.getString("email"));
            log.info("password: {}", rs.getString("password"));
        }

        // 关闭资源
        rs.close();
        stmt.close();
        conn.close();
    }

    public static void main(String[] args) throws Exception {
        // test01();
        test02();
    }

}
