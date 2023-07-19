package com.interview.java8;

import java.util.List;

public class Parent {
    private String name;
    private List<String> childs;
    private String wifeName;

    public Parent(String name, List<String> childs, String wifeName) {
        this.name = name;
        this.childs = childs;
        this.wifeName = wifeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getChilds() {
        return childs;
    }

    public void setChilds(List<String> childs) {
        this.childs = childs;
    }

    public String getWifeName() {
        return wifeName;
    }

    public void setWifeName(String wifeName) {
        this.wifeName = wifeName;
    }
}
