package com.dhcc.cn.framework.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.dhcc.cn.framework.enums.DBTypeEnum;
import com.dhcc.cn.framework.multiple.DynamicDataSource;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
@MapperScan( basePackages = "com.dhcc.cn.framework.mapper")
public class MybatisPlusConfig {

    @Autowired
    CacheConfig mCacheConfig;

    @Autowired
    DruidConfig mDruidConfig;

    //定义mysql
    @Bean(name = "mysql")
    public DataSource mysql() {
        return mDruidConfig.getDataSource();
    }

    //定义cache
    @Bean(name = "cache")
    public DataSource cache() {
        return mCacheConfig.getDataSource();
    }

    /**
     * 动态数据源配置
     * @return
     */
    @Bean
    public DynamicDataSource multipleDataSource(@Qualifier("mysql") DataSource mysql,
                                         @Qualifier("cache") DataSource cache) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DBTypeEnum.MYSQL.getValue(), mysql);
        targetDataSources.put(DBTypeEnum.CACHE.getValue(), cache);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(mysql);
        return dynamicDataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(multipleDataSource(mysql(), cache()));
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/**.xml"));
        return sqlSessionFactory.getObject();
    }

}