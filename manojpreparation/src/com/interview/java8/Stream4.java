package com.interview.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream4 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> list1 = Arrays.asList(5, 6, 7, 8, 9);

        List list2 = list1.stream().distinct().filter(list1::contains).collect(Collectors.toList());
      ArrayList arrayList= list.stream().distinct().filter(list1::contains).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(arrayList);
        System.out.println(list2);
    }
}
