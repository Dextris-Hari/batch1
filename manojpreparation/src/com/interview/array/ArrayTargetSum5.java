package com.interview.array;

public class ArrayTargetSum5 {


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 8, 7, 9};
        int target = 7;


        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {

                if (array[i] + array[j] == target) {

                    System.out.println(array[i] + "," + array[j]);

                }
            }


        }
    }
}
