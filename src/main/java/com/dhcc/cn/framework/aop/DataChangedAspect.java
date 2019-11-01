package com.dhcc.cn.framework.aop;

import com.dhcc.cn.framework.websocket.SocketServer;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 2019/10/30 23
 */
@Aspect
@Component
public class DataChangedAspect {

    private static final Logger logger = LoggerFactory.getLogger(DataChangedAspect.class);

    @Autowired
    SocketServer mServer;

    @Pointcut("@annotation(com.dhcc.cn.framework.annotation.DataChanged)")
    public void annotationPointcut() {

    }

    /**
     * @param joinPoint
     */
    @Before("annotationPointcut()")
    public void beforeDateChanged(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
    }

    @AfterReturning(returning = "ret", pointcut = "annotationPointcut()")
    public void handleDataChanged(Object ret) throws Throwable {
        logger.info("DataChangedAspect : " + ret);
        mServer.sendAll("" + ret);
    }
}
