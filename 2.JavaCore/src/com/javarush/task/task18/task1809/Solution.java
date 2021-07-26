package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try(FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine())){
            List<Integer> list = new ArrayList<>();

            while (fileInputStream.available() > 0){
                list.add(fileInputStream.read());
            }
            for(int i = list.size()-1; i >= 0; i--){
                fileOutputStream.write(list.get(i));
            }

        } catch (IOException e){

        }

    }
}
