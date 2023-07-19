package com.interview.String;

public class PrintSequentialCharactorInString3 {


    public static void main(String[] args) {
        String value="manoj is full stack developer";


        char[] array= value.toCharArray();


        char previous=' ';

        for(Character character:array){


            if(character.equals(previous)){

                System.out.println(previous+" "+character);
            }
            previous=character;
        }




    }
}
