package com.interview.array;

public class FindTheMissingNumberInArray {


    public static void main(String[] args) {

        int [] values={1,2,4,5,6};

        System.out.println(getMissingNumber(values));
    }

    private static int getMissingNumber(int[] values) {
        int length= values.length;
        int sum= ((length+1)*(length+2))/2;

        for(int i=0;i<length;i++){
            sum-=values[i];

        }
        return sum;
    }
}
