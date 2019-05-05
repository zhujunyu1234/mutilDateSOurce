package com.example.demo.config;

import com.example.demo.config.mutilDataSource.DynamicDataSource;
import com.example.demo.config.plugin.DynamicPlugin;
import com.example.demo.config.plugin.IputIinfoPlugin;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class config {

//    @Bean("shawnTimeTransactionManager")
//    public  DynamicDataSourceTransactionManager shawnTimeTransactionManager(){
//        DynamicDataSourceTransactionManager  dt = new DynamicDataSourceTransactionManager();
//        return dt;
//    }
    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("shawnTimeDataSourceRead") DataSource slave,
                                        @Qualifier("shawnTimeDataSourceWrite") DataSource master) {
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setReadDataSource(slave);
            dataSource.setWriteDataSource(master);
        return dataSource;
    }
    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource dataSource) throws Exception {
        DynamicPlugin dynamicPlugin= new DynamicPlugin();
        IputIinfoPlugin myPlugin = new IputIinfoPlugin();
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(dataSource);
        fb.setPlugins(new Interceptor[]{dynamicPlugin,myPlugin});
        return fb.getObject();
    }
    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }


}
