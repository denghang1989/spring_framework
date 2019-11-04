package com.dhcc.cn.framework.multiple;

import com.alibaba.druid.pool.DruidDataSource;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Component
public class DruidDataSourceConfig {

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
