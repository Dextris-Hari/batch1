package com.interview.Math;

public class FibbonaciRecursion2 {


    static   int num1=0,num2=1,num3=0;


    public static void main(String[] args) {


        System.out.print(num1+" "+num2 );
        printFibbonaciRecortion(10);
    }

    private static void printFibbonaciRecortion(int i) {

        if(i>0){
            num3=num1+num2;
            System.out.print(" "+num3);
             num1=num2;
             num2=num3;

            printFibbonaciRecortion(i-1);

        }
    }
}
