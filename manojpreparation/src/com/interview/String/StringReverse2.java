package com.interview.String;

public class StringReverse2 {
    public static void main(String[] args) {

        String value="manoj";
        String reverse="";

        for(int i=value.length()-1;i>=0;i--){
            reverse+=value.charAt(i);

        }
        System.out.println(reverse);

    }
}
