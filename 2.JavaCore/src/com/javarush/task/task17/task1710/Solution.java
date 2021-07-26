package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static  SimpleDateFormat dateFormatOutput;
    public static  SimpleDateFormat dateFormatInput;

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
        dateFormatOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        dateFormatInput = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    }

    public static void main(String[] args) throws ParseException {

        if (args[0].equals("-c")) {
            if (args[2].equals("м")) {
                allPeople.add(Person.createMale(args[1],
                     dateFormatInput.parse(args[3])));
            } else {
                allPeople.add(Person.createFemale(args[1],
                        dateFormatInput.parse(args[3])));
            }
            System.out.println(allPeople.size()-1);//start here - начни тут
        }

        if (args[0].equals("-i")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            if(person.getSex().equals(Sex.MALE)){
                System.out.println(person.getName() +
                        " " + "м" +
                        " " + dateFormatOutput.format(person.getBirthDate()));
            } else {
                System.out.println(person.getName() +
                        " " + "ж" +
                        " " + dateFormatOutput.format(person.getBirthDate()));
            }
            //start here - начни тут
        }

        if (args[0].equals("-u")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(args[2]);
            if (args[3].equals("м")) {
                person.setSex(Sex.MALE);
            } else {
                person.setSex(Sex.FEMALE);
            }
            person.setBirthDate(dateFormatInput.parse(args[4]));

            System.out.println(allPeople.get(0));//start here - начни тут
        }

        if (args[0].equals("-d")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
            System.out.println(allPeople.get(0));//start here - начни тут
        }

    }
}
