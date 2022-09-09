package com.cjlu.config;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface logAnnotation {
    String action() default "";
    String methodDesc() default "";
    String systemType() default "";
    String actionType() default "";
}
