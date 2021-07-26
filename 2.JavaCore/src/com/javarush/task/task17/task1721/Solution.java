package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        BufferedReader firstFileReader = new BufferedReader(new FileReader(firstFileName));
        BufferedReader secondFileReader = new BufferedReader(new FileReader(secondFileName));
        reader.close();

        while (firstFileReader.ready()) {
            allLines.add(firstFileReader.readLine());
        }
        while (secondFileReader.ready()) {
            forRemoveLines.add(secondFileReader.readLine());
        }

        Solution solution = new Solution();
        solution.joinData();
        firstFileReader.close();
        secondFileReader.close();
    }

    public void joinData() throws CorruptedDataException {
        Set<String> secondList = new HashSet<>(forRemoveLines);
        Set<String> resultList = new HashSet<>(forRemoveLines);
        try {
            for (String elem : forRemoveLines) {
                if (!allLines.contains(elem)) {
                    allLines.clear();
                    throw new CorruptedDataException();
                }
                resultList.add(elem);
            }
            allLines.removeAll(secondList);
        } catch (CorruptedDataException ex) {
            throw  new CorruptedDataException();
        }

    }
}
