package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOfFile = reader.readLine();

        FileInputStream stream = new FileInputStream(nameOfFile);
        Map<Integer, Integer> mapOfBytes = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        while (stream.available() > 0) {
            int temp = stream.read();
            list.add(temp);
        }

        for (int i = 0; i < list.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(j).equals(list.get(i))) {
                    count++;
                }
            }
            if (!mapOfBytes.containsKey(list.get(i))) {
                mapOfBytes.put(list.get(i), count);
            }

        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> in : mapOfBytes.entrySet()) {
            if (in.getValue().equals(1)) {
                result.add(in.getKey());
            }
        }

        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i));
            if(i < result.size()-1){
                System.out.print(" ");
            }
        }

        reader.close();
        stream.close();
    }
}
