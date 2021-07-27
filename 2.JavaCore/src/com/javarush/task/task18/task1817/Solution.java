package com.javarush.task.task18.task1817;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {

        StringBuilder builderResult = new StringBuilder();
        StringBuilder builderPath = new StringBuilder();
        for(int i = 0; i< args.length; i++){
            builderPath.append(args[i]);
        }

        try {

            BufferedReader reader = new BufferedReader(new FileReader(builderPath.toString()));

            String line;

            while ((line = reader.readLine()) != null) {
                builderResult.append(line);
            }

            reader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        double countSymbols = builderResult.toString().length();
        double countSpaces = builderResult.toString().length() - builderResult.toString().replaceAll(" ", "").length();

        double result = Math.round((countSpaces / countSymbols * 100) * 100.0) / 100.0 ;
        System.out.println(result);

    }
}
