package com.javarush.task.task19.task1915;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        String pathFile;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            pathFile = reader.readLine();
        }

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();

        try(FileOutputStream fileOutputStream = new FileOutputStream(pathFile)){
            fileOutputStream.write(result.getBytes(StandardCharsets.UTF_8));
        }

        System.setOut(consoleStream);
        System.out.println(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

