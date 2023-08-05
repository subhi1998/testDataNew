package com.subhiagrawal.testFolder;

import com.subhiagrawal.testFolder.model.Board;
import com.subhiagrawal.testFolder.model.User;
import com.subhiagrawal.testFolder.model.ListData;
import com.subhiagrawal.testFolder.model.Card;
import com.subhiagrawal.testFolder.service.TrelloManager;
import java.time.LocalDateTime;
import java.util.*;


public class Main {

    public static void main(String[] args){

        TrelloManager trelloManager = new TrelloManager();

        // Create users
        User user1 = new User("John Doe", "john@example.com");
        User user2 = new User("Jane Smith", "jane@example.com");

        // Add users to the application
        trelloManager.addUser(user1);
        trelloManager.addUser(user2);

        // Create boards
        Board board1 = new Board("Project A", "https://example.com/boardA");
        Board board2 = new Board( "Project B", "https://example.com/boardB");

        // Add boards to the application
        trelloManager.addBoard(board1);
        trelloManager.addBoard(board2);

        // Create lists
        ListData list1 = new ListData("To Do", new ArrayList<>());
        ListData list2 = new ListData("In Progress", new ArrayList<>());
        ListData list3 = new ListData("Done", new ArrayList<>());

        // Add lists to the board
        trelloManager.addList(board1.getId(), list1);
        trelloManager.addList(board1.getId(), list2);
        trelloManager.addList(board1.getId(), list3);

        // Create cards
        Card card1 = new Card( "Task 1", "This is the description of Task 1", null, 1, LocalDateTime.now(), null, null, "TODO");
        Card card2 = new Card( "Task 2", "This is the description of Task 2", user1, 2, LocalDateTime.now(), null, null, "TODO");
        Card card3 = new Card( "Task 3", "This is the description of Task 3", user2, 3, LocalDateTime.now(), null, null, "IN_PROGRESS");
        Card card4 = new Card("Task 4", "This is the description of Task 4", null, 4, LocalDateTime.now(), null, null, "DONE");

        // Add cards to the lists
        trelloManager.addCard(list1.getId(), card1);
        trelloManager.addCard(list1.getId(), card2);
        trelloManager.addCard(list2.getId(), card3);
        trelloManager.addCard(list3.getId(), card4);
        trelloManager.watchCard(user1.getUserId(), card1.getcardId());

        Card watchedCard = trelloManager.getCard(card1.getcardId());
        System.out.println("Watched Card Details:");
        System.out.println("Name: " + watchedCard.getName());
        System.out.println("Description: " + watchedCard.getDescription());
        System.out.println("Assigned User: " + (watchedCard.getAssignedUser() != null ? watchedCard.getAssignedUser().getName() : "Unassigned"));
        System.out.println("Status: " + watchedCard.getStatus());

        // Move a card across lists
        trelloManager.moveCard(card3.getcardId(), list2.getId(), list3.getId());

        // Show all boards
        List<Board> allBoards = trelloManager.getAllBoards();
        System.out.println("All Boards:");
        for (Board board : allBoards) {
            System.out.println(board.getName());
        }

        // Show cards for a list
        List<Card> listCards = trelloManager.getAllCards(list1.getId());
        System.out.println("All Cards in List 1:");
        for (Card card : listCards) {
            System.out.println(card.getName() + " - " + card.getStatus());
        }

        // Show cards for a user (Bonus Feature: Bookmark)
        trelloManager.bookmarkCard(user1.getUserId(), card1.getcardId());
        trelloManager.bookmarkCard(user1.getUserId(), card2.getcardId());

        List<Card> bookmarkedCards = trelloManager.getBookmarkedCards(user1.getUserId());
        System.out.println("Bookmarked Cards for User1:");
        for (Card card : bookmarkedCards) {
            System.out.println(card.getName());
        }

        // Search cards (Additional Complexity for SDE2)
        List<Card> searchResults = trelloManager.searchCards(user2.getUserId(), "Task");
        System.out.println("Search Results for User2:");
        for (Card card : searchResults) {
            System.out.println(card.getName() + " - " + card.getStatus());
        }

        // Watch card (Additional Complexity for SDE2)
        trelloManager.watchCard(user2.getUserId(), card3.getcardId());

    }

}