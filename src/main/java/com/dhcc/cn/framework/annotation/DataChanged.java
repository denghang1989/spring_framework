package com.dhcc.cn.framework.annotation;

import com.dhcc.cn.framework.enums.TopicEmum;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 2019/10/30 23
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface DataChanged {

    TopicEmum value();

    String topic() default "";

}
