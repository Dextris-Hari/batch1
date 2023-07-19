package com.interview.array;

public class FindTheMissingNumberInArray5 {
    public static void main(String[] args) {



        int [] array={1,2,3,4,5,6,8};


        printMissing(array);
    }
    public static void printMissing(int[] array){
      int length= array.length;

      int sum = ((length+1)*(length+2))/2;

      for(int value: array){

          sum-=value;
      }

        System.out.println(sum
        );

    }
}
