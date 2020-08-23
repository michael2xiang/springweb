package com.imooc.web1.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

@Configuration
@MapperScan("com.imooc.web1.dao")
public class DataSourceConfiguration {
    @Value("${jdbc.driver:org.h2.Driver}")
    private String jdbcDriver;
    @Value("${jdbc.url:jdbc:h2:F:/06_code_train/web1/db}")
    private String jdbcUrl;
    @Value("${jdbc.user:root}")
    private String jdbcUser;
    @Value("${jdbc.psw:root}")
    private String jdbcPsw;

    @Bean(name = "myDataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUser);
        dataSource.setPassword(jdbcPsw);
        dataSource.setAutoCommitOnClose(false);
        return dataSource;

    }

}
