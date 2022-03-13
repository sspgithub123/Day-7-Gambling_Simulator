package com.bridgelabz;

import java.util.Random;

public class GamblingSimulator {
    //UC1
    public static int STAKE = 100;
    public static int BET = 1;
    public static int Win = 0;
    public static int Loose = 0;

    //UC2
    public static void checkWinOrLoose() {
        Random Number = new Random();
        int randomNumber = Number.nextInt(2);
        if (randomNumber == 0) {
            Win = BET;
            System.out.println("Gambler has won ");
            System.out.println(" ");
        } else {
            Loose = BET;
            System.out.println("Gambler has lost ");
            System.out.println(" ");
        }
    }
    //UC3
    public static void wonOrLost50Percent(){
        while(STAKE > 50 && STAKE < 150) {
            double winOrLoss = Math.floor(Math.random() * 10) % 2;
            if (BET == winOrLoss) {
                System.out.println("Gambler has Won");
                STAKE = STAKE +1;
                System.out.println("The current stake is " + STAKE);
            }
            else
            {
                System.out.println("The Gambler has lost");
                STAKE = STAKE -1;
                System.out.println("The remaining stake is: " + STAKE);
            }
        }
        if(STAKE == 50) {
            System.out.println("The Gambler LOST 50% of stake, So he have to resign for the day. ");
        }
        else {
            System.out.println("The Gambler WON 50% of stake, So he have to resign for the day. ");
        }
        System.out.println(" ");
    }
    public static void main(String[] args) {
        System.out.println("Welcome to the Gambling Simulator Game");
        System.out.println(STAKE + " " + BET);
        System.out.println(" ");
        checkWinOrLoose();
        wonOrLost50Percent();
    }
}