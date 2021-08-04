package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        String[] resultArray = result.split(" ");

//        if(result.charAt(2)=='+'){
//
//        }
        int firstNum = Integer.parseInt(resultArray[0].trim());
        int secondNum = Integer.parseInt(resultArray[2].trim());
        int arithmeticResult = 0;
        String operation = resultArray[1].trim();
        switch (operation) {
            case "+":
                arithmeticResult = (firstNum + secondNum);
                break;
            case "-":
                arithmeticResult = (firstNum - secondNum);
                break;
            case "*":
                arithmeticResult = (firstNum * secondNum);
                break;
        }

        System.setOut(consoleStream);
        System.out.println(firstNum + " " + operation + " " + secondNum + " = " + arithmeticResult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

