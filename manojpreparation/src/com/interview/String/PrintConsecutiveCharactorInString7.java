package com.interview.String;

public class PrintConsecutiveCharactorInString7 {

    public static void main(String[] args) {




        String value="ABCXYZFE";
        char[] array= value.toCharArray();

        System.out.print(array[0]);
        for(int i=1;i<array.length;i++){

            if(array[i]==array[i-1]+1||array[i]==array[i-1]-1){

                System.out.print(array[i]);
            }
            else {
                System.out.print("\n"+array[i]);
            }
        }



    }

}
