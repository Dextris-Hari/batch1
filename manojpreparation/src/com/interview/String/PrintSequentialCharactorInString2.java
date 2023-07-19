package com.interview.String;

public class PrintSequentialCharactorInString2 {
    public static void main(String[] args) {

        String vaue= "manoj is java full stack developer";

      char [] array=  vaue.toCharArray();
      char previous=' ';

      for(Character character:array){
          if(character==previous){
              System.out.println(character+" "+previous);
          }
          else {
              previous=character;
          }
      }


    }
}
