package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOfFile = reader.readLine();

        FileInputStream stream = new FileInputStream(nameOfFile);
        Set<Integer> set = new HashSet<>();

        while (stream.available() > 0) {
            int temp = stream.read();
            set.add(temp);
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i));
            if(i < list.size()-1){
                System.out.print(" ");
            }
        }
        reader.close();
        stream.close();
    }
}
