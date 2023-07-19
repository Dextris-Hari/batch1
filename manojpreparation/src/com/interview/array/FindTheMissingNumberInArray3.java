package com.interview.array;

public class FindTheMissingNumberInArray3 {

    public static void main(String[] args) {
        int[] array = {1,2,3,8,4,5,6};

        System.out.println(missingNumber(array));
    }

    private static int missingNumber(int[] array) {

        int length= array.length;
        int sum=((length+1)*(length+2))/2;

        for(int number:array){

            sum-=number;
        }
       return sum;

    }
}
