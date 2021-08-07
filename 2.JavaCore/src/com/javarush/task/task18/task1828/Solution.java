package com.javarush.task.task18.task1828;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        int lengthOfId = 8;
        int lengthOfProductName = 30;
        int lengthOfPrice = 8;
        int lengthOfQuantity = 4;

        if ((args.length != 5) && (args.length != 2)) {
            return;
        }

        String flag = args[0];
        String idInput = args[1];


        String path;

        if (flag.equals("-u")) {

            String productName = args[2];
            String price = args[3];
            String quantity = args[4];

            try (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    FileReader fileReader = new FileReader(path = reader.readLine());
                    Scanner scanner = new Scanner(fileReader);
            ) {
                List<String> readList = new ArrayList<>();

                int idOfStringInFile = 0;

                while (scanner.hasNext()) {
                    readList.add(scanner.nextLine());
                }

                for (int i = 0; i < readList.size(); i++) {
                    if(readList.get(i).substring(0,8).trim().equals(idInput)){
                        idOfStringInFile = i;
                    }
                }

                System.out.println(idOfStringInFile);

                //Начинаем запись
                String idString = formatString(idInput, lengthOfId);
                productName = formatString(productName, lengthOfProductName);
                price = formatString(price, lengthOfPrice);
                quantity = formatString(quantity, lengthOfQuantity);

                try (FileWriter fileWriter = new FileWriter(path)){

                    for(int i = 0; i < idOfStringInFile; i++){
                        System.out.println(readList.get(i));
                        fileWriter.write(readList.get(i) + "\n");
                    }
                    fileWriter.write(idString + productName + price + quantity + "\n");

                    for(int i = idOfStringInFile+1; i < readList.size(); i++){
                        fileWriter.write(readList.get(i) + "\n");
                    }
                }
            }
        }

        if (flag.equals("-d")) {
            try (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    FileReader fileReader = new FileReader(path = reader.readLine());
                    Scanner scanner = new Scanner(fileReader);
            ) {
                List<String> readList = new ArrayList<>();

                int idOfStringInFile = 0;

                while (scanner.hasNext()) {
                    readList.add(scanner.nextLine());
                }

                for (int i = 0; i < readList.size(); i++) {
                    if(readList.get(i).substring(0,8).trim().equals(idInput)){
                        idOfStringInFile = i;
                    }
                }

                //Начинаем запись
                try (FileWriter fileWriter = new FileWriter(path)){

                    for(int i = 0; i < idOfStringInFile; i++){
                        System.out.println(readList.get(i));
                        fileWriter.write(readList.get(i) + "\n");
                    }

                    for(int i = idOfStringInFile+1; i < readList.size(); i++){
                        fileWriter.write(readList.get(i) + "\n");
                    }
                }
            }
        }

    }

    public static String formatString(String begin, int length) {
        String result = begin;

        if (begin.length() < length) {
            for (int i = 0; i < (length - begin.length()); i++) {
                result = result + " ";
            }
        } else if (begin.length() > length) {
            result = begin.substring(0, length);
        }
        return result;
    }
}
