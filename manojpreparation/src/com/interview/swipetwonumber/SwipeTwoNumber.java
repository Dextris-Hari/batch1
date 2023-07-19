package com.interview.swipetwonumber;

public class SwipeTwoNumber {


    public static void main(String[] args) {


        int a=10,b=20;

      // using temp variable

      int temp=a;
      a=b;
      b=temp;
        System.out.println(a+" "+b);
        // using bitwise
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println(a+" "+b);

        // using sum

        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println(a+" "+b);


    }
}
