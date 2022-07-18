package com.example.mvptest.mvp.v7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author pk
 * @description
 * @date 7/18/22 10:41 AM
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) //指定它的注解类型为变量
public @interface InjectPresenter {
}
