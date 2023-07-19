package com.interview.array;

public class FindTheMissingNumberInArray2 {
    public static void main(String[] args) {

        int[] array={1,2,3,4,6,7,8,9};


      int missing=  printMissingNumber(array);
        System.out.println(missing);
    }

    private static int printMissingNumber(int[] array) {
        int length= array.length;

        int sum= ((length+1)*(length+2))/2;

        for(int number:array){

            sum-=number;
        }
        return  sum;
    }
}
