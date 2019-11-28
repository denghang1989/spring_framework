package com.dhcc.cn.framework.aop;

import com.dhcc.cn.framework.annotation.DataChanged;
import com.dhcc.cn.framework.datechanged.DataChangedContext;
import com.dhcc.cn.framework.datechanged.DataChangedInterface;
import com.dhcc.cn.framework.enums.TopicEmum;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;

/**
 * 2019/10/30 23
 */
@Aspect
@Component
@Slf4j
public class DataChangedAspect {

    @Autowired
    DataChangedContext mContext;

    @Pointcut("@annotation(com.dhcc.cn.framework.annotation.DataChanged)")
    public void annotationPointcut() {

    }

    /**
     * @param joinPoint
     */
    @Before("annotationPointcut()")
    public void beforeDateChanged(JoinPoint joinPoint) {

    }

    @AfterReturning(returning = "ret", pointcut = "annotationPointcut()")
    public void handleDataChanged(JoinPoint joinPoint, Object ret) throws Throwable {
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        if (ret instanceof Number) {
            if ((Long) ret > 0) {
                Method method = sign.getMethod();
                DataChanged dataChanged = method.getAnnotation(DataChanged.class);
                String topic = dataChanged.topic();
                TopicEmum topicEmum = dataChanged.value();
                DataChangedInterface instance = mContext.getInstance(topic);
                mContext.handleTopic(instance, topicEmum, (Long) ret);
            }
        }
    }

}
