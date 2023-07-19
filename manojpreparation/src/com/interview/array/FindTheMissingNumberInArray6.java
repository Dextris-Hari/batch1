package com.interview.array;

public class FindTheMissingNumberInArray6 {


    public static void main(String[] args) {



        int [] array ={1,2,3,4,6,7,8,9};

        int sum = ((array.length+1)*(array.length+2))/2;

        for(int number:array){

            sum-=number;
        }
        System.out.println(sum);
    }
}
