package com.subhiagrawal.snakeandladder;

import com.subhiagrawal.snakeandladder.model.Entities;
import com.subhiagrawal.snakeandladder.service.PlaySnakeAndLadder;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        Entities entities = Entities.getInstance();

        int noOfSnakes = sc.nextInt();

        while(noOfSnakes>=1)
        {
            int startPosition=sc.nextInt();
            int endPosition=sc.nextInt();
            entities.setSnakes(startPosition, endPosition);
            noOfSnakes--;
        }

        int noOfLadders = sc.nextInt();

        while(noOfLadders>=1)
        {
            int startPosition=sc.nextInt();
            int endPosition=sc.nextInt();
            entities.setLadders(startPosition, endPosition);
            noOfLadders--;
        }

        int noOfPlayers = sc.nextInt();
        int i=0;
        while(noOfPlayers>=1)
        {
            String player=sc.next();
            entities.setPlayers(i++, player);
            noOfPlayers--;
        }

        PlaySnakeAndLadder playSnakeAndLadder =new PlaySnakeAndLadder(6);
        System.out.println(playSnakeAndLadder.playGame()+" wins");


    }
}