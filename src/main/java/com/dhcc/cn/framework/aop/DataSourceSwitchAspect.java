package com.dhcc.cn.framework.aop;

import com.dhcc.cn.framework.enums.DBTypeEnum;
import com.dhcc.cn.framework.multiple.DbContextHolder;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component
@Order(value = -100)
@Aspect
public class DataSourceSwitchAspect {

    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(* com.dhcc.cn.framework.service.mysql..*.*(..))")
    private void mysqlAspect() {
    }

    @Pointcut("execution(* com.dhcc.cn.framework.service.cache..*.*(..))")
    private void cacheAspect() {
    }

    @Before("mysqlAspect()")
    public void mysql(JoinPoint joinPoint) {
        logger.info("mysql");
        DbContextHolder.setDbType(DBTypeEnum.MYSQL);
    }

    /**
     * 清除数据源上下文
     */
    @After("mysqlAspect()")
    public void mysqlAfter() {
        logger.info("mysql");
        DbContextHolder.clearDbType();
    }

    @Before("cacheAspect()")
    public void cache(JoinPoint joinPoint) {
        logger.info("CACHE");
        DbContextHolder.setDbType(DBTypeEnum.CACHE);
    }

    /**
     * 清除数据源上下文
     */
    @After("cacheAspect()")
    public void cacheAfter() {
        logger.info("CACHE");
        DbContextHolder.clearDbType();
    }
}