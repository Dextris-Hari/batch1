package com.xworkz.user1.dao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

@Target({ElementType.FIELD,ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Manoj {

}
