package com.dhcc.cn.framework.config;

import com.intersys.jdbc.CacheXADataSource;

import org.springframework.stereotype.Component;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Component
public class CacheConfig {

    @Resource
    private CacheParam mCacheParam ;

    public DataSource getDataSource () {
        CacheXADataSource datasource = new CacheXADataSource();
        try {
            datasource.setURL(mCacheParam.getUrl());
            datasource.setUser(mCacheParam.getUsername());
            datasource.setPassword(mCacheParam.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datasource;
    }

}
