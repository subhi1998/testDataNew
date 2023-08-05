package com.subhiagrawal.snakeandladder.service;

import com.subhiagrawal.snakeandladder.model.Dice;
import com.subhiagrawal.snakeandladder.model.Entities;
import com.subhiagrawal.snakeandladder.model.PairPosition;
import java.util.HashMap;

public class PlaySnakeAndLadder {

    HashMap<String, PairPosition> playerHistory;
    HashMap<String, Integer> playersLatestPosition;
    Entities entities;
    Dice dice;

    public PlaySnakeAndLadder (int N)
    {
        playerHistory =new HashMap<>();
        playersLatestPosition = new HashMap<>();
        entities = Entities.getInstance();
        dice = new Dice(N);
    }

    public String playGame()
    {
        initializePlayersPosition();
        int i=0;
        while(true)
        {
            String player = entities.getPlayers().get(i);
            int num=dice.getNumInDice();
            int currentPos = playersLatestPosition.get(player);

            String sl="";
            if(currentPos+num == 100) {
                playersLatestPosition.put(player,currentPos+num);
                System.out.println(player + " rolled a " + num + " and moved from " + currentPos + " to " +
                        playersLatestPosition.get(player) + sl);
                break;
            }
            if(currentPos+num <100)
            {
                if(entities.getLadders().containsKey(currentPos+num))
                {
                    playersLatestPosition.put(player, entities.getLadders().get(currentPos+num));
                    sl="after Ladder ride";
                }
                else if(entities.getSnakes().containsKey(currentPos+num))
                {
                    playersLatestPosition.put(player, entities.getSnakes().get(currentPos+num));
                    sl="after Snakes Dinner";
                }
                else
                    playersLatestPosition.put(player,currentPos+num);

                if(playersLatestPosition.get(player) == 100) {
                    System.out.println(player + " rolled a " + num + " and moved from " + currentPos + " to " +
                            playersLatestPosition.get(player) + sl);
                    break;
                }
                System.out.println(player + " rolled a "+ num+ " and moved from "+currentPos+" to "+
                        playersLatestPosition.get(player)+sl);
            }
            else
            {
                System.out.println(player + " rolled a "+ num+
                        " not moved as the new pos was exceeding 100. Since current pos was "+ currentPos);
            }
            i++;
            if(i==entities.getPlayers().size())
                i=0;
        }

        return entities.getPlayers().get(i);
    }

    private boolean isWon(String player)
    {
        return playersLatestPosition.get(player)==100;
    }

    private void initializePlayersPosition()
    {
        HashMap<Integer,String> players = entities.getPlayers();
        for(int i=0;i<players.size();i++)
        {
            playersLatestPosition.put(players.get(i),0);
        }
    }

}
