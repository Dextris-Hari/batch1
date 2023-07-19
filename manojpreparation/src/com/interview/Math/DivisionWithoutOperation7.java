package com.interview.Math;

public class DivisionWithoutOperation7 {

    public static void main(String[] args) {

        int divider=10;
        int divident=105;

        int quetient=0;

        while(divident>=divider){
            divident-=divider;
            quetient++;

        }
        System.out.println(quetient);

    }
}
