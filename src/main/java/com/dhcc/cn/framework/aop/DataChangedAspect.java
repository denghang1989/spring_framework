package com.dhcc.cn.framework.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 2019/10/30 23
 */
@Aspect
@Component
@Slf4j
public class DataChangedAspect {

    @Pointcut("@annotation(com.dhcc.cn.framework.annotation.DataChanged)")
    public void annotationPointcut() {

    }

    /**
     * @param joinPoint
     */
    @Before("annotationPointcut()")
    public void beforeDateChanged(JoinPoint joinPoint){

    }

    @AfterReturning(returning = "ret", pointcut = "annotationPointcut()")
    public void handleDataChanged(Object ret) throws Throwable {

    }

}
