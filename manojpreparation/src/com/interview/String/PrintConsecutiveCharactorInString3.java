package com.interview.String;

public class PrintConsecutiveCharactorInString3 {


    public static void main(String[] args) {
        String s="ABCDGHIJXYZ";

        print(s);
    }

    private static void print(String s) {
        char[] array= s.toCharArray();

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
