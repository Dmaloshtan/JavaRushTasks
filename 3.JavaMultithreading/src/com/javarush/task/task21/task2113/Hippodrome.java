package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hippodrome {

    public static Hippodrome game;

    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = Arrays.asList(new Horse("Брычка", 3, 0),
                new Horse("Качка", 3, 0),
                new Horse("Мочка", 3, 0));

        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for(Horse horse : horses){
            horse.move();
        }
    }

    public void print() {
        for(Horse horse : horses){
            horse.print();
        }
        for(int i = 0; i < 10; i++){
            System.out.println("");
        }
    }

    public Horse getWinner(){
        double distance = 0;
        Horse horse = null;
        for(Horse h : horses){
            if(h.getDistance() > distance){
                distance = h.getDistance();
                horse = h;
            }
        }
        return horse;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
