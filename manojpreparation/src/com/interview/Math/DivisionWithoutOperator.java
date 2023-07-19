package com.interview.Math;

public class DivisionWithoutOperator {


    public static void main(String[] args) {
        int dividend = 10;
        int divider = 3;
        System.out.println(divide(dividend, divider));
    }

    private static int divide(int dividend, int divider) {

        if (divider == 0) {

            throw new IllegalArgumentException("cont divided by 0");
        }
        int quetient = 0;

        while (dividend >= divider) {
            dividend -= divider;
            quetient++;


        }

        return quetient;

    }
}
