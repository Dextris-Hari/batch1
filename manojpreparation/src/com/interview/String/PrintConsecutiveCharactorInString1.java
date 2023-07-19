package com.interview.String;

public class PrintConsecutiveCharactorInString1 {
    public static void main(String[] args) {
        print("abcdxyz");
    }

    private static void print(String abcdxyz) {

        char[] array=abcdxyz.toCharArray();
        System.out.print(array[0]);
        
        for( int i=1;i<array.length;i++){

            if(array[i]==array[i-1]+1||array[i]==array[i-1]+1){
                System.out.print(array[i]+"1");
            }
            else {
                System.out.println(+array[i]);
            }
        }
    }
}
