package com.interview.array;

public class ArrayTargetSum1 {


    public static void main(String[] args) {
        int array[] = {1, 2, 3, 5, 8, 4, 9, 6, 7, 2};
        int target = 9;


        for (int i = 0; i < array.length; i++) {

            for (int j = i + 1; j < array.length; j++) {

                if (array[i] + array[j] == target) {

                    System.out.println(array[i] + "," + array[j]);

                }
            }
        }
    }
}
