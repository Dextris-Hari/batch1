package com.interview.array;

public class FindTheMissingNumberInArray8 {

    public static void main(String[] args) {


        int[] array = {1, 2, 3, 4, 5, 6, 8};
        int n = array.length;
        int number = 0;

        int sum = ((n + 1) * (n + 2)) / 2;

        for (Integer integer : array) {

            number = sum - integer;
            sum -= integer;
        }
        System.out.println(number);
    }
}
