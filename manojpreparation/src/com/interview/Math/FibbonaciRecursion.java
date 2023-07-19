package com.interview.Math;

public class FibbonaciRecursion {
    static int n1 = 0;
    static int n2 = 1;
    static int n3;

    public static void main(String[] args) {
        System.out.print(n1 + " " + n2);
        print(10);

    }

    public static void print(int num) {

        if (num > 0) {
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
           n2 = n3;
          print(num-1);
        }


    }
}
