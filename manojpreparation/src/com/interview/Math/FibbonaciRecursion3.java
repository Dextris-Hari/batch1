package com.interview.Math;

public class FibbonaciRecursion3 {
    static  int num1=0;
    static int num2=1;
    static int  num3=0;

    public static void main(String[] args) {
        System.out.print(num1+" "+num2);
        print(10);



    }

    private static void print(int i) {

        if(i>0){
            num3=num1+num2;
            System.out.print(" "+num3);
             num1=num2;
             num2=num3;
            print(i-1);

        }


    }
}
