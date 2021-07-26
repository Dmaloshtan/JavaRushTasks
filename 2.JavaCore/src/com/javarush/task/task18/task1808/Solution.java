package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String firstFilePath = reader.readLine();
            String secondFilePath = reader.readLine();
            String thirdFilePath = reader.readLine();
            FileInputStream streamIn = new FileInputStream(firstFilePath);
            FileOutputStream firstOutputStream = new FileOutputStream(secondFilePath);
            FileOutputStream secondOutputStream = new FileOutputStream(thirdFilePath);

            int halfOfFile = (streamIn.available() +1) / 2;
            int count = 0;
            while (streamIn.available() > 0){
                if(count < halfOfFile){
                    firstOutputStream.write(streamIn.read());
                    count++;
                } else {
                    secondOutputStream.write(streamIn.read());
                }
            }

            reader.close();
            streamIn.close();
            firstOutputStream.close();
            secondOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
