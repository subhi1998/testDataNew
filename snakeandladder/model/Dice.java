package com.subhiagrawal.snakeandladder.model;

import java.util.Random;
public class Dice {

    private int numOfDice;
    private static int minNoDice =1;

    Random random;

    public Dice(int numOfDice)
    {
        random=new Random();
        this.numOfDice = numOfDice;
    }

    public int getNumInDice()
    {
        return random.nextInt((this.numOfDice-minNoDice)+1)+1;
    }
}
