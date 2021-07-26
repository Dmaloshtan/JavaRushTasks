package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOfFile = reader.readLine();

        FileInputStream stream = new FileInputStream(nameOfFile);
        int max = stream.read();

        while (stream.available() > 0){
            int temp = stream.read();
            if(temp > max){
                max = temp;
            }
        }
        System.out.println(max);
        reader.close();
        stream.close();
    }
}
