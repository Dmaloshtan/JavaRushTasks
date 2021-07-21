package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String url = reader.readLine();
            reader.close();
            url = url.split("\\?")[1];

            String[] array = url.split("&");
            ArrayList<String> list = new ArrayList<>();
            String objParam = null;
            for (int i = 0; i< array.length; i++) {
                String name = array[i].split("=")[0];
                list.add(name);
                System.out.print(name);
                if(i < array.length -1)
                System.out.print(" ");

                if(name.equals("obj")){
                    objParam = array[i].split("=")[1];
                }
            }
            System.out.println("");
            if(objParam != null){

                try{
                    alert(Double.parseDouble(objParam));

                } catch (NumberFormatException ex){
                    alert(objParam);
                }
            }



            //add your code here
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
