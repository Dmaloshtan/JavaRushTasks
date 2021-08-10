package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String file = null;


        while (true){
            file = bufferedReader.readLine();

            try(FileReader reader = new FileReader(file)) {

            } catch (FileNotFoundException e) {
                System.out.println(file);
                bufferedReader.close();
                break;
            }
        }

    }
}
