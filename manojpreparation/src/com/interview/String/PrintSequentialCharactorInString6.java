package com.interview.String;

public class PrintSequentialCharactorInString6 {


    public static void main(String[] args) {
        String value="manoj is full stack devveloper ";

     char[] array=   value.toCharArray();
     char previous=' ';
     for(char current:array){

         if(current==previous){

             System.out.println(current+","+previous);
         }
         else {
             previous=current;
         }

     }




    }
}
