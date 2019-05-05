package com.example.demo.config.mutilDataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 读取配置源信息
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "shawnTimeDataSourceRead")
    @Qualifier("shawnTimeDataSourceRead")
    @ConfigurationProperties(prefix = "my2.datasource")
    @Primary()
    public DataSource shawnTimeDataSourceRead() {
        return DataSourceBuilder.create().build();

    }

    @Bean(name = "shawnTimeDataSourceWrite")
    @Qualifier("shawnTimeDataSourceWrite")
    @ConfigurationProperties(prefix = "my.datasource")
    @Primary()
    public DataSource shawnTimeDataSourceWrite() {
        return DataSourceBuilder.create().build();

    }

}
