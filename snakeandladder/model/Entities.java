package com.subhiagrawal.snakeandladder.model;

import java.util.HashMap;

public class Entities {

    private HashMap<Integer,Integer> snakes;
    private HashMap<Integer, Integer> ladders;

    private HashMap<Integer, String> players;

    private static Entities instance;

    private Entities()
    {
        snakes=new HashMap<>();
        ladders=new HashMap<>();
        players=new HashMap<>();
    }

    public void setSnakes(int start, int end)
    {
        snakes.put(start,end);
    }
    public HashMap<Integer, Integer> getSnakes()
    {
        return snakes;
    }

    public void setLadders(int start, int end)
    {
        ladders.put(start,end);
    }
    public HashMap<Integer, Integer> getLadders()
    {
        return ladders;
    }

    public void setPlayers(int index, String player)
    {
        players.put(index,player);
    }
    public HashMap<Integer, String> getPlayers()
    {
        return players;
    }

    public static Entities getInstance()
    {
        if(instance == null)
            instance= new Entities();
        return instance;
    }

}
