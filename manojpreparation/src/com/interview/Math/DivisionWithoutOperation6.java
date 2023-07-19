package com.interview.Math;

public class DivisionWithoutOperation6 {


    public static void main(String[] args) {


       int divider=3;
       int divident=25;
       int quetient=0;
       while (divident>=divider){

           divident-=divider;
           quetient++;
       }
        System.out.println(quetient);

    }
}
