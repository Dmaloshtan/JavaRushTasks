package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread(new FirstThread()));
        threads.add(new Thread(new SecondThread()));
        threads.add(new Thread(new ThirdThread()));
        threads.add(new FourthThread());
        threads.add(new Thread(new FifthThread()));
    }

    public static void main(String[] args) {
        for(Thread th : threads){
            th.start();
        }



    }

    public static class FirstThread implements Runnable {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class SecondThread implements Runnable {
        @Override
        public void run() {
            try {
                throw new InterruptedException();
            } catch (InterruptedException ex) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThirdThread implements Runnable {
        @Override
        public void run() {

            try {
                while (true){
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static class FourthThread extends Thread implements Message {
        boolean isRun = true;

        @Override
        public void run() {

            while (isRun){

            }
        }

        @Override
        public void showWarning() {
            if(isAlive()){
                isRun = false;
            }
        }
    }

    public static class FifthThread implements Runnable {

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;

            while (true) {

                try {
                    String str = reader.readLine();
                    if (str.equals("N")) {
                        break;
                    }
                    int temp = Integer.parseInt(str);
                    sum += temp;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(sum);
        }
    }


}