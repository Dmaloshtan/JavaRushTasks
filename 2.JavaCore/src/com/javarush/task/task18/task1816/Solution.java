package com.javarush.task.task18.task1816;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            String s;

            while((s = reader.readLine()) != null){
                builder.append(s);
            }

        } catch (IOException ex){
            ex.printStackTrace();
        }

        String str = builder.toString().replaceAll("[^a-zA-Z]", "");
        System.out.println(str.length());
    }
}
