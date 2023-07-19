package com.interview.swipetwonumber;

public class SwipeTwoNumber1 {
    public static void main(String[] args) {

        int a=10;
        int b=20;
        // using temp variable

        int temp=a;
        a=b;
        b=temp;
        System.out.println(a+" "+b);
        //using bit wise
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println(a+" "+b);
        // sum
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println(a+" "+b);


    }
}
