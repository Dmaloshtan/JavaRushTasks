package com.javarush.task.task18.task1827;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        int lengthOfId = 8;
        int lengthOfProductName = 30;
        int lengthOfPrice = 8;
        int lengthOfQuantity = 4;

        if (args.length != 4) {
            return;
        }

        String flag = args[0];
        String productName = args[1];
        String price = args[2];
        String quantity = args[3];

        String path;

        if (flag.equals("-c")) {
            try (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    FileReader fileReader = new FileReader(path = reader.readLine());
                    Scanner scanner = new Scanner(fileReader);
            ) {
                List<String> readList = new ArrayList<>();
                List<Integer> listId = new ArrayList<>();
                while (scanner.hasNext()) {
                    readList.add(scanner.nextLine());
                }
                for (String s : readList) {
                    int id = Integer.parseInt(s.substring(0, 8).trim()) + 1;
                    listId.add(id);
                }

                int id = Collections.max(listId);

                //Начинаем запись
                String idString = String.valueOf(formatString(String.valueOf(id), lengthOfId));
                productName = formatString(productName, lengthOfProductName);
                price = formatString(price, lengthOfPrice);
                quantity = formatString(quantity, lengthOfQuantity);


            try (FileWriter fileWriter = new FileWriter(path, true)){
                fileWriter.write("\n" + idString + productName + price + quantity);
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
