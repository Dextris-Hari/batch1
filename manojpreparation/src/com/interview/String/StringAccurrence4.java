package com.interview.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StringAccurrence4 {
    public static void main(String[] args) {


        String value="manojhj";
        HashMap<Character,Integer> hashSet= new HashMap<>();

        for(char c:value.toCharArray()){
            hashSet.put(c,hashSet.getOrDefault(c,0)+1);

        }
        System.out.println(hashSet);


        value.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(
                Function.identity(),Collectors.counting()
        )).forEach((emp,in)-> System.out.println(emp+";"+in));
    }
}
