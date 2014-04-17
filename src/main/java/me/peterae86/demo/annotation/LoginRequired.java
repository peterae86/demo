/*
 * Copyright (c) 2013 Qunar.com. All Rights Reserved.
 */

package me.peterae86.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired {

}
