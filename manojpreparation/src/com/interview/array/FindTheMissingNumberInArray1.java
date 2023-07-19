package com.interview.array;

public class FindTheMissingNumberInArray1 {


    public static void main(String[] args) {
        int[] array = {1, 4, 2, 5, 6, 3, 8};
        System.out.println(missingNumber(array));


    }

    private static int missingNumber(int[] array) {
        int length = array.length;

        int sum = ((length + 1) * (length + 2)) / 2;
        for (int num : array) {
            sum -= num;
        }
return sum;

    }
}

