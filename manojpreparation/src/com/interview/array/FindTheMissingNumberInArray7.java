package com.interview.array;

public class FindTheMissingNumberInArray7 {


    public static void main(String[] args) {


        int[] array={1,2,4,5,3,6,8};

        int sum= ((array.length+1)*(array.length+2))/2;
        for(int l:array){

            sum-=l;

        }
        System.out.println(sum);

    }
}
