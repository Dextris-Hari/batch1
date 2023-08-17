package com.interview.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {


        Class aClass=Class.forName("com.interview.reflection.Test");
        Test test=(Test) aClass.newInstance();

        Method method=aClass.getDeclaredMethod("show",null);
        method.setAccessible(true);
        method.invoke(test,null);

        Field field=aClass.getField("v");
        field.setAccessible(true);
        field.set(test,100);
        System.out.println(test.v);
    }
}
