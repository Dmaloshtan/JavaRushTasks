package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String firstFileName;
        String secondFileName;
        List<Integer> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }

        try(FileReader fileReader = new FileReader(firstFileName)){
            while (fileReader.ready()){
                list.add(fileReader.read());
            }
        }

        try(FileWriter fileWriter = new FileWriter(secondFileName)){
            for(int i = 1; i< list.size(); i+=2){
                fileWriter.write(list.get(i));
            }
        }

    }
}
