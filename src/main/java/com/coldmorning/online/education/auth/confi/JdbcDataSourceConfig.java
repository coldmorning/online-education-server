package com.coldmorning.online.education.auth.confi;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcDataSourceConfig {
    /*
    // First Datasource Jdbc Template
    @Primary
    @Bean(name = "firstDataSource")
    @Qualifier("firstDataSource")
    @ConfigurationProperties(prefix="spring.datasource.druid.first")
    public DataSource primaryDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    // Second Datasource Jdbc Template
    @Bean(name = "secondDataSource")
    @Qualifier("secondDataSource")

    @ConfigurationProperties(prefix="spring.datasource.druid.second")
    public DataSource secondaryDataSource() {
        return DruidDataSourceBuilder.create().build();
    }


    // MariaDB Jdbc

    @Bean(name="mysqlJdbcTemplate")
    public JdbcTemplate mysqlJdbcTemplate (
            @Qualifier("firstDataSource")  DataSource dataSource ) {
        return new JdbcTemplate(dataSource);
    }

    // Oracle Jdbc
    @Bean(name="oracleJdbcTemplate")
    public JdbcTemplate  oracleJdbcTemplate(
            @Qualifier("secondDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    */
}
