package com.siddhant.protorypes.MasterReplicaDB.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean(name = "masterDataSource")
    @ConfigurationProperties("spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/master_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true")
                .username("root")
                .password("rootpass")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    @Bean(name = "masterJdbcTemplate")
    public JdbcTemplate masterJdbcTemplate(@Qualifier("masterDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "replicaDataSource")
    @ConfigurationProperties("spring.datasource.replica")
    public DataSource replicaDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/replica_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true")
                .username("root")
                .password("rootpass")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    @Bean(name = "replicaJdbcTemplate")
    public JdbcTemplate replicaJdbcTemplate(@Qualifier("replicaDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
