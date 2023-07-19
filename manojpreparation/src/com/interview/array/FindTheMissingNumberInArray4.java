package com.interview.array;

public class FindTheMissingNumberInArray4 {
    public static void main(String[] args) {


        int[] array={1,2,3,5,6,8,7};
        System.out.println(printMissing(array));
    }
    public static  int printMissing(int[] array){


        int sum= ((array.length+1)*(array.length+2))/2;
        for(int i=0;i<array.length;i++){
            sum-=array[i];
        }
     return    sum;
    }
}
