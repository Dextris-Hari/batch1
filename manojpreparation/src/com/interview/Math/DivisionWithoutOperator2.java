package com.interview.Math;

public class DivisionWithoutOperator2 {
    public static void main(String[] args) {
        int divider=3;
        int divident=10;
        int quetient=findquetient( divider, divident);
        System.out.println(quetient);
    }

    private static int findquetient(int divider, int divident) {

        int quetient=0;
        while(divident>=divider){

           divident-=divider;
           quetient++;
        }

       return quetient;
    }
}
