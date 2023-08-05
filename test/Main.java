package com.subhiagrawal.test;

import com.subhiagrawal.test.models.BList;

import com.subhiagrawal.snakeandladder.model.Entities;
import com.subhiagrawal.snakeandladder.service.PlaySnakeAndLadder;

//import models.BList;
import com.subhiagrawal.test.models.Card;
import com.subhiagrawal.test.models.User;
import com.subhiagrawal.test.service.BoardService;
import com.subhiagrawal.test.service.impl.BoardServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


public class Main {

    public static void main(String[] args){
        User user1 = new User("u1","u1@gmail.com");
        User user2 = new User( "u2","u2@gmail.com");
        User user3 = new User( "u3","u3@gmail.com");
        User user4 = new User( "u4","u4@gmail.com");

        List<User> users = new ArrayList<>(Arrays.asList(user1,user2,user3,user4));


        // Cards
        Card card1 = new Card("Production","Smooth Release", 1, System.currentTimeMillis());
        card1.setAssignedUser(user1);
        Card card2 = new Card("Feature Complete","On Time", 0, System.currentTimeMillis());

        Card card3 = new Card("Performance","Need to optimize", 2, System.currentTimeMillis());
        card3.setAssignedUser(user2);

        // Lists
        BList bList1 = new BList("What went well");
        bList1.setCards(Arrays.asList(card1,card2));

        BList bList2 = new BList("What can be Improved Items");

        BList bList3 = new BList("Action Items");
        bList3.setCards(Arrays.asList(card3));




        BoardService boardServcie = new BoardServiceImpl();
        UUID id =boardServcie.createBoard("Sprint Retro");
        // Adding List to Board
        boardServcie.addListToBoard(id,bList1);
        boardServcie.addListToBoard(id,bList2);
        boardServcie.addListToBoard(id,bList3);

        // Adding users to Board
        boardServcie.addUsersToBoard(id,users);

        // Print Board
        boardServcie.getBoard(id);
        //boardServcie.showBoards();
        System.out.println("\n For User u1");
        boardServcie.showBoardByUser(id, "u1");
        System.out.println("\n Sorted By Created Time");

        boardServcie.showBoardByPriority(id);
    }

}