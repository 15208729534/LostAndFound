package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

/*
测试数据库连接
 */
@SpringBootTest
public class TestDemo {

    @Autowired
    DataSource dataSource;

    @Test
    void cont() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
