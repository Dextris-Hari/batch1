package com.interview.String;

public class PrintSequentialCharactorInString7 {
    public static void main(String[] args) {


        String value="manoj is full stack developer";

       char[] c
        =value.toCharArray();
       char previous=' ';

       for(char current:c){

           if(current==previous){
               System.out.println(current+","+previous);
           }
           previous=current;
       }



    }
}
