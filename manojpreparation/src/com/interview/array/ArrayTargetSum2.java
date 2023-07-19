package com.interview.array;

public class ArrayTargetSum2 {

    public static void main(String[] args) {


        int[] array={1,2,3,4,5,6,7,8,9,10};
         int target = 10;

         for(int i=0;i<array.length;i++){
             for(int j=i+1;j<array.length;j++){

                 if(array[j]+array[i]==target){
                     System.out.println(array[i]+" "+array[j]);

                 }
             }



        }





    }
}
