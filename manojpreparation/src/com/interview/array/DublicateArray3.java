package com.interview.array;

public class DublicateArray3 {
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,2,1,3,5,7,8,9,5,1};


        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]==array[j])
                    System.out.println(array[i]);
            }
        }
    }
}
