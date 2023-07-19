package com.interview.Math;

public class AccurenceInNumber {
    public static void main(String[] args) {
        int value = 1111;
        for (int i = 0; i < 10; i++) {


            int count = 0;
            int temp = value;
            while (temp > 0) {
                int digit = temp % 10;
                if (digit == i) {
                    count++;
                }
                temp /= 10;

            }
            if (count > 0) {
                System.out.println("digit  " + i + "  accurse  " + count + "  times.  ");
            }
        }
    }
}
