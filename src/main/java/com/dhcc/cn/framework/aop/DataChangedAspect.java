package com.dhcc.cn.framework.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 2019/10/30 23
 */
@Aspect
@Component
public class DataChangedAspect {

    @Pointcut("@annotation(com.dhcc.cn.framework.annotation.DataChanged)")
    public void annotationPointcut() {

    }

    @After("annotationPointcut()")
    public void handleDataChanged(JoinPoint joinPoint){

    }
}
