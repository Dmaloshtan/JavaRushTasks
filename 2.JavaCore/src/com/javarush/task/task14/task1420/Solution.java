package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            long a = Long.parseLong(reader.readLine());
            long b = Long.parseLong(reader.readLine());
            if (a <= 0 || b <= 0) {
                throw new Exception();
            }
            long c = NOD(a,b);
            System.out.println(c);

    }

    public static long NOD(long a, long b){
        if(a % b == 0) {
           return b;
        }
        return NOD(b, a % b);
    }
}
