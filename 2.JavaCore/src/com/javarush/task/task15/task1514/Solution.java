package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static{
        labels.put(2.5,"qwet");
        labels.put(2.3,"qwey");
        labels.put(2.2,"qweu");
        labels.put(2.1,"qwei");
        labels.put(2.0,"qweo");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
