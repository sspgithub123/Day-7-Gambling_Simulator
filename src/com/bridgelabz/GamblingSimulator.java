package com.bridgelabz;

import java.io.PrintStream;
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
    public static int wonOrLost50Percent(){
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
        return 0;
    }

    //UC4
    public static void twentyDays() {
        int day = 20;
        int totalMoney = 0;
        for (int i = 0; i <= day; i++) {
            int temp = wonOrLost50Percent();
            if (temp - STAKE > 50) {
                totalMoney = totalMoney + (temp - STAKE);
                System.out.println(" Winning day " + i + ": Money Won is" + totalMoney);
            } else {
                totalMoney = totalMoney + (STAKE - temp);
                System.out.println("Loosing day " + i + ": Money Lost  is " + totalMoney);
            }
        }
        System.out.println(" ");
    }

    //UC5
    public static void eachMonth(){
        int Stake = STAKE;
        int month = 1;

        while (month<=1) {
            int day = 1;
            System.out.println("Month " + month);

            while (day <= 30) {
                Stake = STAKE;

                int rand = (int) Math.floor(Math.random() * 10) % 2;
                if (rand == BET) {
                    Stake = STAKE + 1;
                } else {
                    Stake = STAKE - 1;
                }

                if (Stake < STAKE) {
                    System.out.println("Day " + day + " lost by " + (STAKE - Stake) + " $ ");
                } else {
                    System.out.println("Day " + day + " won by " + (Stake - STAKE) + " $ ");
                }
                day++;
            }
            month++;
            System.out.println();
        }

    }

    //UC6
    public static PrintStream luckyUnluckyDay(){
        int Stake = STAKE;
        int month = 1;
        int day = 1;
        int UnluckyDay = 1;
        int LuckyDay = 1;
        int UnluckyMonth= 1;
        int LuckyMonth = 1;
        int LuckyDayMoney = STAKE;
        int UnluckyDayMoney = STAKE;

        while (month<=12) {
            day = 1;
            while(day<=30) {
                Stake = STAKE;
                Random rand = new Random();
                int dailyGamePlayed = rand.nextInt(10);

                for (int i = 0; i < dailyGamePlayed; i++) {

                    int randcheck = (int)Math.floor(Math.random()*10) % 2;
                    if (randcheck==BET)
                        Stake = Stake + 1;
                    else
                        Stake = Stake - 1;
                }

                if(LuckyDayMoney<Stake){
                    LuckyDay = day;
                    LuckyMonth = month;
                    LuckyDayMoney = Stake;
                }

                if(UnluckyDayMoney>Stake) {
                    UnluckyDay = day;
                    UnluckyMonth = month;
                    UnluckyDayMoney = Stake;
                }
                day++;
            }
            month++;
        }
        System.out.println("Lucky Day "+LuckyDay+" in the month "+LuckyMonth+" Maximum money won is "+(LuckyDayMoney - Stake)+" $ ");
        return System.out.printf("Unlucky Day "+UnluckyDay+" in the month "+UnluckyMonth+" Maximum  money lost is " +(Stake - UnluckyDayMoney)+" $ ");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Gambling Simulator Game");
        System.out.println(STAKE + " " + BET);
        System.out.println(" ");
        checkWinOrLoose();
        wonOrLost50Percent();
        twentyDays();
        eachMonth();
        luckyUnluckyDay();
    }
}