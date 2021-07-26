package com.javarush.task.task18.task1807;

import java.io.*;
import java.util.*;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOfFile = null;
        FileInputStream stream = null;
        List<Integer> list = new ArrayList<>();
        try {
            nameOfFile = reader.readLine();
            stream = new FileInputStream(nameOfFile);
            while (stream.available() > 0) {
                int temp = stream.read();
                list.add(temp);
            }
            reader.close();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int count = 0;
        for(Integer in : list){
            if(in.equals(44)){
                count++;
            }
        }
        System.out.println(count);
    }
}
