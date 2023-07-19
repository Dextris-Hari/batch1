package com.interview.Math;

public class DivisionWithoutOperator4 {

    public static void main(String[] args) {
        int divider =3;
        int divident=10;
        System.out.println(printQuetient(divident,divider));
    }

    private static int printQuetient(int divident, int divider) {

        if(divider==0){
            throw new IllegalArgumentException("cont divided by 0");

        }
        int quetient=0;
        while(divident>=divider){
            divident-=divider;

            quetient++;
        }
        return quetient;
    }
}
