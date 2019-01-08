package com.chx.tools.common.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @Author yanuun
 * @Date 11:22 2019/1/8
 **/
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface JobLog {
    String description() default "";

    @AliasFor("description")
    String value() default "";
}
