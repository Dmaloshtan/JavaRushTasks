package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(scanner);
        Person person = personScannerAdapter.read();
        System.out.println(person);

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String read = fileScanner.nextLine();
            String[] arr = read.split(" ");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(arr[5]), Integer.parseInt(arr[4]) - 1, Integer.parseInt(arr[3]));
            Date date = calendar.getTime();
            return new Person(arr[1], arr[2], arr[0], date);
        }

        @Override
        public void close() throws IOException {
        fileScanner.close();
        }
    }
}
