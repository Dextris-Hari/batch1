package com.interview.String;

import com.interview.java8.Stream;

import java.lang.reflect.Array;

public class StringReverseUsingJava8 {


    public static void main(String[] args) {
        String s="manoj";


     String s1=   s.chars()
                .mapToObj(c->String.valueOf((char)c))
                .reduce("",(acc,str)->str+acc);
        System.out.println(s1
        );

     String s2=   s.chars().mapToObj(c->String.valueOf((char)c)).reduce(
                "",(acc,str)->str+acc
        );
        System.out.println(s2);
    }
}
