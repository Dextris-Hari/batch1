package com.interview.String;

public class StringReverseUsingJava82 {

    public static void main(String[] args) {
        String value = "manoj";

        String s
                = value.chars().mapToObj(c -> String.valueOf((char) c))
                .reduce("", (acc, str) -> str + acc);

        System.out.println(s);


    }
}
