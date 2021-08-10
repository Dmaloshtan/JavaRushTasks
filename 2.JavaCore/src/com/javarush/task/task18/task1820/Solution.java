package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathFirstFile = reader.readLine();
        String pathSecondFile = reader.readLine();
        reader.close();
        ArrayList<Long> list = new ArrayList<>();

        try (FileInputStream inputStream = new FileInputStream(pathFirstFile);
             PrintWriter writer = new PrintWriter(new FileWriter(pathSecondFile));
             Scanner scanner = new Scanner(inputStream)
        ) {
            while (scanner.hasNext()){
              double num =  scanner.nextDouble();
              long result = Math.round(num);
              list.add(result);
            }

            for(Long lg: list){
                writer.print(lg + " ");
            }
        }


    }
}
