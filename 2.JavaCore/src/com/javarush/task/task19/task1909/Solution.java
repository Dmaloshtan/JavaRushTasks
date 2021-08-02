package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String firstFileName = null;
        String secondFileName = null;
        List<String> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(firstFileName))){
            while (bufferedReader.ready()){
                list.add(bufferedReader.readLine());
            }
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(secondFileName))){
            for(String s : list){
                writer.write(s.replaceAll("\\.", "!"));
            }
        }
    }
}
