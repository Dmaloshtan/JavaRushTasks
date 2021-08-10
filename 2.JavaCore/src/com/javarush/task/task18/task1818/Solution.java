package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String pathFirstFile;
        String pathSecondFile;
        String pathThirdFile;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        pathFirstFile = bufferedReader.readLine();
        pathSecondFile = bufferedReader.readLine();
        pathThirdFile = bufferedReader.readLine();


        try (FileOutputStream fileOutputStream = new FileOutputStream(pathFirstFile);
             FileInputStream fileInputStream1 = new FileInputStream(pathSecondFile);
             FileInputStream fileInputStream2 = new FileInputStream(pathThirdFile)) {

            while (fileInputStream1.available() > 0) {
                fileOutputStream.write(fileInputStream1.read());
            }
            while (fileInputStream2.available() > 0) {
                fileOutputStream.write(fileInputStream2.read());
            }
        }

    }
}
