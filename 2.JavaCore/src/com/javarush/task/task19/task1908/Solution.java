package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        List<String> stringList = new ArrayList<>();
        String firstFileName;
        String secondFileName;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();

            try(BufferedReader reader1 = new BufferedReader(new FileReader(firstFileName))){
               while (reader1.ready()){
                stringList.add(reader1.readLine());
               }
            }
        }

        try (BufferedWriter outputFileWriter = new BufferedWriter(new FileWriter(secondFileName))) {
            for (String line : stringList) {

                String[] splitLine = line.trim().split(" ");
                for (String word : splitLine) {
                    try {
                        int num = Integer.parseInt(word);
                        outputFileWriter.write(word + " ");
                    } catch (Exception ignore) {
                        continue;
                    }
                }
            }
        }

    }
}
