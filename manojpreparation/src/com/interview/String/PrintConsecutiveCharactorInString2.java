package com.interview.String;

public class PrintConsecutiveCharactorInString2 {
    public static void main(String[] args) {
        String value="abcdopuvxyz";

        printConsecutive(value);
    }

    private static void printConsecutive(String value) {
        char[] array=value.toCharArray();
        System.out.print(array[0]);
        for(int i=1;i<array.length;i++){
            if(array[i]==array[i-1]+1||array[i]==array[i-1]-1){
                System.out.print(array[i]);
            }
            else{
                System.out.print("\n"+array[i]);
            }

        }

    }
}
