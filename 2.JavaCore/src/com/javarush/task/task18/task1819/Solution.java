package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String pathFileFirst = null;
        String pathFileSecond = null;
        ArrayList<Integer> firstFile = new ArrayList<>();
        ArrayList<Integer> secondFile = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ) {
            pathFileFirst = reader.readLine();
            pathFileSecond = reader.readLine();
        }

        try( FileInputStream inputStream = new FileInputStream(pathFileFirst)){
            while (inputStream.available() > 0) {
                firstFile.add(inputStream.read());
            }
        }

        try(FileOutputStream outputStream = new FileOutputStream(pathFileFirst);
        FileInputStream inputStream = new FileInputStream(pathFileSecond)){

            while (inputStream.available() > 0) {
                secondFile.add(inputStream.read());
            }
            for(Integer in : secondFile){
                outputStream.write(in);
            }
            for(Integer in : firstFile){
                outputStream.write(in);
            }
        }

    }
}
