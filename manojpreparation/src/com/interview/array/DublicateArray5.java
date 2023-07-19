package com.interview.array;

public class DublicateArray5 {
    public static void main(String[] args) {


        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 12, 5, 4, 6};


        for (int i = 0; i < array.length; i++) {


            for (int j = i + 1; j < array.length; j++) {


                if (array[i] == array[j]) {
                    System.out.println(array[i]);
                }
            }
        }
    }
}
