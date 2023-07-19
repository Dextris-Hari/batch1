package com.interview.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream2 {


    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> list1 = Arrays.asList(5, 6, 7, 8, 9);

        List list2 = list
                .stream().map(num -> list1.stream()
                        .filter(num1 -> num == num1).findFirst().orElse(null)).collect(Collectors.toList());

        System.out.println(list2);
      List list3=  list.stream().distinct().filter(list1::contains).collect(Collectors.toList());

        System.out.println(list3);

    }
}
