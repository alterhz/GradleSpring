package com.javaeffective.chapter3.test;

import java.util.HashMap;
import java.util.Map;

public class TestJava {

    public static void main(String[] args) {
        Map<String, String> testMap = new HashMap<>();

        String name = testMap.get("name");

        String ss = name + "ddd";

        System.out.println("ss:" + ss);
    }
}
