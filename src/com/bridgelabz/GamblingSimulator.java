package com.bridgelabz;

import java.util.Random;

public class GamblingSimulator {
    public static int STAKE = 100;
    public static int BET = 1;
    public static int Win = 0;
    public static int Loose = 0;

    public static void checkWinOrLoose() {
        Random Number = new Random();
        int randomNumber = Number.nextInt(2);
        if (randomNumber == 0) {
            Win = BET;
            System.out.println("Gambler has won ");
        } else {
            Loose = BET;
            System.out.println("Gamler has lost ");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Gambling Simulator Game");
        System.out.println(STAKE + " " + BET);
        System.out.println(" ");
        checkWinOrLoose();
    }
}