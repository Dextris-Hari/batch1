package com.interview.String;

public class PrintSequentialCharactorInString {

    public static void main(String[] args) {
        String value = "java full stack developer";
        Character character = null;

        for (Character character1 :value.toCharArray()) {

            if (character1 == character) {

                System.out.println(character1 +""+ character);
            }
            character = character1;

        }


    }
}
