package com.dhcc.cn.framework.aop;

import com.dhcc.cn.framework.annotation.DataSourceSwitch;
import com.dhcc.cn.framework.enums.DBTypeEnum;
import com.dhcc.cn.framework.multiple.DbContextHolder;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

import lombok.extern.slf4j.Slf4j;


@Component
@Order(value = -100)
@Slf4j
@Aspect
public class DataSourceSwitchAspect {

    @Pointcut("execution(* com.dhcc.cn.framework.service..*.*(..))")
    private void dbAspect() {
    }

    @Before( "dbAspect()" )
    public void db(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        DataSourceSwitch dataSourceSwitch = methodSignature.getMethod().getAnnotation(DataSourceSwitch.class);
        if (Objects.isNull(dataSourceSwitch) || Objects.isNull(dataSourceSwitch.value())) {
            DbContextHolder.setDbType(DBTypeEnum.MYSQL);
        }else{
            switch (dataSourceSwitch.value().getValue()) {
                case "mysql":
                    DbContextHolder.setDbType(DBTypeEnum.MYSQL);
                    break;
                case "cache":
                    DbContextHolder.setDbType(DBTypeEnum.CACHE);
                    break;
                default:
                    DbContextHolder.setDbType(DBTypeEnum.MYSQL);
            }
        }
    }
}