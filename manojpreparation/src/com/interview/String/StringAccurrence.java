package com.interview.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringAccurrence {


    public static void main(String[] args) {

        String value = "manoj";


        HashMap<Character, Integer> hashSet = new HashMap();

        for (char c : value.toCharArray()) {
            hashSet.put(c, hashSet.getOrDefault(c, 0) + 1);
        }
        System.out.println(hashSet);
        // using java 8

        Map<Character, Long> map = value.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String accurrence = "japanjapan";
        HashMap<Character, Integer> hashMap = new HashMap();

        for (Character c : accurrence.toCharArray()) {


            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        System.out.println(hashMap);

        Map<Character, Long> characterLongMap = accurrence.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(characterLongMap);


    }
}
