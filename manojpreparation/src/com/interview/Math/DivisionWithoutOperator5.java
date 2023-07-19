package com.interview.Math;

public class DivisionWithoutOperator5 {
    public static void main(String[] args) {

        int divider = 10;
        int divident = 100;

        printQuetient(divident, divider);


    }

    private static void printQuetient(int divident, int divider) {
        if (divider == 0) {
            throw new IllegalArgumentException(" cont be divided by zero");
        }

        int quetient = 0;
        while (divident >= divider) {

            divident -= divider;
            quetient++;
        }
        System.out.println(quetient);


    }
}
