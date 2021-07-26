package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Только по-очереди!
*/

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        t1.start();
        t1.join();
        t2.start();
        t2.join();//add your code here - добавьте код тут

        t1.printResult();
        System.out.println("");
        t2.printResult();
    }

    public static class Read3Strings extends Thread {
        public String result = "";


        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    result += reader.readLine() + " ";
                }
            } catch (IOException ex) {
                System.out.println("Ошибка");
            }
        }

        public void printResult() {
            System.out.print(result);
        }
    }


    //add your code here - добавьте код тут
}
