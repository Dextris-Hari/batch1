package com.interview.Math;

public class DivisionWithoutOperator3 {
    public static void main(String[] args) {


        int divident = 10;
        int divider = 3;
        System.out.println(quetient(divident, divider));
    }

    private static int quetient(int divident, int divider) {
        int quetient = 0;
        while (divident >= divider) {
            divident -= divider;
            quetient++;
        }

        return quetient;

    }
}
