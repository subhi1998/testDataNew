package com.subhiagrawal.testFolder.service;

import com.subhiagrawal.testFolder.model.Board;
import com.subhiagrawal.testFolder.model.User;
import com.subhiagrawal.testFolder.model.ListData;
import com.subhiagrawal.testFolder.model.Card;

import java.util.HashMap;
import java.util.*;

public class TrelloManager {

    HashMap<UUID, User> users;
    HashMap<UUID, Board> boards;
    HashMap<UUID, CardWatcher> cardWatchers;

    public TrelloManager(){
        this.users = new HashMap<>();
        this.boards = new HashMap<>();
        this.cardWatchers = new HashMap<>();
    }

    public void addUser(User user)
    {
        users.put(user.getUserId(), user);
    }

    public  User getUser(UUID userId)
    {
        return users.get(userId);
    }

    public  void deleteUser(UUID userId)
    {
       users.remove(userId);
    }

    public void addBoard(Board board)
    {
        boards.put(board.getId(), board);
    }

    public  Board getBoard(UUID boardId)
    {
        return boards.get(boardId);
    }

    public void deleteBoard(UUID boardId)
    {
        boards.remove(boardId);
    }

    public void addList(UUID boardId, ListData list)
    {
        if(boards.get(boardId)!=null)
          boards.get(boardId).getList().add(list);
    }

    public ListData getList(UUID listId)
    {
        for(Board board: boards.values())
        {
            for(ListData list: board.getList())
            {
                if(list.getId().equals(listId))
                {
                    return list;
                }
            }

        }
        return null;
    }

    public void deleteList(UUID listId)
    {
        for(Board board: boards.values())
        {
            for(ListData list: board.getList())
            {
                if(list.getId().equals(listId))
                {
                    board.getList().remove(list);
                }
            }

        }
    }

    public void addCard(UUID listId, Card card)
    {
        for(Board board: boards.values())
        {
            for(ListData list:board.getList())
            {
                if(list.getId().equals(listId))
                {
                    list.getCards().add(card);
                }
            }
        }
    }

    public Card getCard(UUID cardId)
    {
        for(Board board: boards.values())
        {
            for(ListData list:board.getList())
            {
                for(Card card: list.getCards())
                {
                    if(card.getcardId().equals(cardId))
                    {
                        return card;
                    }
                }
            }
        }
        return null;
    }

    public void deleteCard(UUID cardId)
    {
        for(Board board: boards.values())
        {
            for(ListData list:board.getList())
            {
                for(Card card: list.getCards())
                {
                    if(card.getcardId().equals(cardId))
                    {
                        list.getCards().remove(card);
                    }
                }
            }
        }
    }

    // Methods for moving cards across lists
    public void moveCard(UUID cardId, UUID sourceListId, UUID targetListId) {
        Card card = getCard(cardId);
        if (card != null) {
            ListData sourceList = getList(sourceListId);
            ListData targetList = getList(targetListId);
            if (sourceList != null && targetList != null) {
                sourceList.getCards().remove(card);
                targetList.getCards().add(card);
            }
        }
    }

    // Methods for showing boards and other details
    public List<Board> getAllBoards() {
        return new ArrayList<>(boards.values());
    }

    public List<Board> getBoardsForUser(UUID userId) {
        List<Board> userBoards = new ArrayList<>();
        for (Board board : boards.values()) {
            if (board.getMemberList().contains(getUser(userId))) {
                userBoards.add(board);
            }
        }
        return userBoards;
    }

    public List<ListData> getAllLists(UUID boardId) {
        Board board = getBoard(boardId);
        if (board != null) {
            return board.getList();
        }
        return new ArrayList<>();
    }

    public List<Card> getAllCards(UUID listId) {
        ListData list = getList(listId);
        if (list != null) {
            return list.getCards();
        }
        return new ArrayList<>();
    }

    // Bonus Feature: Bookmark
    public void bookmarkCard(UUID userId, UUID cardId) {
        User user = getUser(userId);
        Card card = getCard(cardId);
        if (user != null && card != null) {
            card.setAssignedUser(user);
        }
    }

    public List<Card> getBookmarkedCards(UUID userId) {
        List<Card> bookmarkedCards = new ArrayList<>();
        for (Board board : boards.values()) {
            for (ListData list : board.getList()) {
                for (Card card : list.getCards()) {
                    if (card.getAssignedUser() != null && card.getAssignedUser().getUserId().equals(userId)) {
                        bookmarkedCards.add(card);
                    }
                }
            }
        }
        return bookmarkedCards;
    }

    // Additional Complexity for SDE2: Search and Watch
    public List<Card> searchCards(UUID userId, String keyword) {
        List<Card> searchResults = new ArrayList<>();
        for (Board board : boards.values()) {
            for (ListData list : board.getList()) {
                for (Card card : list.getCards()) {
                    if (card.getName().contains(keyword) || card.getDescription().contains(keyword)) {
                        searchResults.add(card);
                    }
                }
            }
        }
        return searchResults;
    }

    public void watchCard(UUID userId, UUID cardId) {
        User user = getUser(userId);
        Card card = getCard(cardId);

        if (user == null || card == null) {
            System.out.println("Invalid user or card ID.");
            return;
        }

        CardWatcher cardWatcher = cardWatchers.getOrDefault(cardId, new CardWatcher(cardId));
        cardWatcher.addWatcher(user);
        cardWatchers.put(cardId, cardWatcher);

        System.out.println(user.getName() + " is now watching the card: " + card.getName());

        // Notify the user about the current status of the card
        String message = "Card status: " + card.getStatus();
        cardWatcher.notifyWatchers(message);
    }
}
