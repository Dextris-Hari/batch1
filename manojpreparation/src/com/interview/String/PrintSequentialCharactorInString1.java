package com.interview.String;

public class PrintSequentialCharactorInString1 {

    public static void main(String[] args) {
        String value=" manoj is full stack developer";
        printSequential(value);
    }

    private static void printSequential(String value) {
     char[] array= value.toCharArray();
     Character previous=null;
     for(Character current:array){
         if(current==previous){
             System.out.println(current+""+previous);
         }
         previous=current;
     }

    }
}
