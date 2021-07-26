package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOfFile = reader.readLine();

        FileInputStream stream = new FileInputStream(nameOfFile);
        int min = stream.read();

        while (stream.available() > 0){
            int temp = stream.read();
            if(temp < min){
                min = temp;
            }
        }
        System.out.println(min);
        reader.close();
        stream.close();
    }
}
