package com.javarush.task.task18.task1826;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws UnsupportedEncodingException {
        

        try(FileInputStream fileInputStream = new FileInputStream(args[1]);
             FileOutputStream fileOutputStream = new FileOutputStream(args[2])){

            if (args[0].equals("-e")) {
                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(fileInputStream.read() + 32);
                }
            } else {
                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(fileInputStream.read() - 32);
                }
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
        
    }


}
