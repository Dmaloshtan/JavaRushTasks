package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileName = reader.readLine();
        }

        StringBuilder builder = new StringBuilder();
        try(FileReader fileReader = new FileReader(fileName)){
            char ch;
            while (fileReader.ready()){
                ch = (char)fileReader.read();
                builder.append(ch);
            }
        }

        int counter = 0;
        String replacedString = builder.toString().replaceAll("\\p{P}", " ").replaceAll("\\s", " ");

        for (String x : replacedString.split(" ")) {
            if (x.equals("world")) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}
