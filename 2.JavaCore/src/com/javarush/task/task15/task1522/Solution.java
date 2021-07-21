package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        if(str.equals(Planet.EARTH)){
            thePlanet = Earth.getInstance();// implement step #5 here - реализуйте задание №5 тут
        } else if(str.equals(Planet.SUN)){
            thePlanet = Sun.getInstance();
        } else if(str.equals(Planet.MOON)){
            thePlanet = Moon.getInstance();
        } else {
            thePlanet = null;
        }
    }
}
