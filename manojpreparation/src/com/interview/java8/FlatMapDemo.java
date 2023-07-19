package com.interview.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapDemo {


    public static void main(String[] args) {
        List<String> childsName = new ArrayList<>();

        childsName.add("manoj");
        childsName.add("jayanth");

        Parent parent = new Parent("jayaram", childsName, "jyothi");
        List<String> childsName2 = new ArrayList<>();

        childsName2.add("sandya");
        childsName2.add("sukanya");

        Parent parent2 = new Parent("somaya", childsName2, "gayathri");
        List<Parent> parents = new ArrayList<>();

        parents.add(parent);
        parents.add(parent2);
     List list=   parents.stream()
                .flatMap(l->l.getChilds().stream()).collect(Collectors.toList());

        System.out.println(list);
    }
}
