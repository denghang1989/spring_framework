package com.dhcc.cn.framework.config;

import com.alibaba.druid.pool.DruidDataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Component
public class DruidConfig {

    @Resource
    private DruidParam druidOneParam ;

    public DataSource getDataSource () {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(druidOneParam.getUrl());
        datasource.setUsername(druidOneParam.getUsername());
        datasource.setPassword(druidOneParam.getPassword());
        datasource.setDriverClassName(druidOneParam.getDriverClassName());
        return datasource;
    }

}
