package com.subhiagrawal.test.service.impl;

import com.subhiagrawal.test.models.BList;
import com.subhiagrawal.test.models.Board;
import com.subhiagrawal.test.models.Card;
import com.subhiagrawal.test.models.User;
import com.subhiagrawal.test.service.BoardService;

import java.util.*;

public class BoardServiceImpl implements BoardService {
    HashMap<UUID, Board> boards;
    public BoardServiceImpl(){
        boards = new HashMap<>();
    }

    @Override
    public UUID createBoard(String name) {
        Board board = new Board(name);
        this.boards.put(board.getId(),board);
        return board.getId();
    }

    @Override
    public void deleteBoard(UUID boardId) throws Exception {
        if(boards.get(boardId)!=null) boards.remove(boardId);
        else throw new Exception("Board "+boardId+" Not preset in List of Boards");
    }

    @Override
    public void addUsersToBoard(UUID boardId, List<User> users) {
        Board board = boards.get(boardId);
        if(board!=null){
            List<User> boardUsers = board.getMembers();
            boardUsers.addAll(users);
            board.setUsers(users);
        }
        boards.put(boardId,board);
    }

    @Override
    public void addUserToBoard(UUID boardId, User user) {
        Board board = boards.get(boardId);
        if(board!=null){
            List<User> users = board.getMembers();
            users.add(user);
            board.setUsers(users);
        }
        boards.put(boardId,board);
    }

    @Override
    public void addListToBoard(UUID boardId, BList bList) {
        Board board = boards.get(boardId);
        if(board!=null){
            List<BList> bLists = board.getLists();
            bLists.add(bList);
            board.setLists(bLists);
        }
        boards.put(boardId,board);
    }

    @Override
    public void getBoard(UUID boardId) {
        Board board = boards.get(boardId);
        System.out.println(" Board Id "+board.getId());
        board.getLists().forEach(
                bList -> {
                    StringBuilder str = new StringBuilder();
                    str.append(" \n List Name: ").append(bList.getName());
                    bList.getCards().forEach(
                            card -> {
                                str.append(" \n Card Name: ").
                                        append(card.getName()).
                                        append(" Card Description: ").append(card.getDescription())
                                        .append(" Assigned User : ").append(
                                                card.getAssignedUser()!=null?card.getAssignedUser().getUserName():" Not Assigned"
                                        );
                            }
                    );
                    if(bList.getCards().size()==0) str.append(" Empty List: ");
                    System.out.println(str);
                }
        );
    }

    @Override
    public void showBoards() {
        for (Map.Entry<UUID, Board> mapElement : boards.entrySet()) {
            UUID key = mapElement.getKey();
            getBoard(key);
            System.out.println("\n");
        }
    }

    @Override
    public void showBoardByUser(UUID boardId, String assignedUser) {
        Board board = boards.get(boardId);
        System.out.println(" Board Id "+board.getId());
        board.getLists().forEach(
                bList -> {
                    StringBuilder str = new StringBuilder();
                    //str.append(" \n List Name: ").append(bList.getName());
                    bList.getCards().forEach(
                            card -> {
                                if (card.getAssignedUser()!= null && assignedUser.equalsIgnoreCase(card.getAssignedUser().getUserName())) {
                                    str.append(" \n List Name: ").append(bList.getName());
                                    str.append(" \n Card Name: ").
                                            append(card.getName()).
                                            append(" Card Description: ").append(card.getDescription())
                                            .append(" Assigned User : ").append(
                                                    card.getAssignedUser() != null ? card.getAssignedUser().getUserName() : " Not Assigned"
                                            );
                                }
                            }
                    );
                    //if(bList.getCards().size()==0) str.append(" Empty List: ");
                    System.out.println(str);
                }
        );
    }

    @Override
    public void showBoardByCreatedTime(UUID boardId) {
        Board board = boards.get(boardId);
        System.out.println(" Board Id "+board.getId());
        board.getLists().forEach(
                bList -> {
                    StringBuilder str = new StringBuilder();
                    str.append(" \n List Name: ").append(bList.getName());
                    bList.getCards().stream().sorted(Comparator.comparing(Card::getCreatedTime)).forEach(
                            card -> {
//                                    str.append(" \n List Name: ").append(bList.getName());
                                    str.append(" \n Card Name: ").
                                            append(card.getName()).
                                            append(" Card Description: ").append(card.getDescription())
                                            .append(" Assigned User : ").append(
                                                    card.getAssignedUser() != null ? card.getAssignedUser().getUserName() : " Not Assigned"
                                            );
                                }
                    );
                    //if(bList.getCards().size()==0) str.append(" Empty List: ");
                    System.out.println(str);
                }
        );
    }

    @Override
    public void showBoardByPriority(UUID boardId) {
        Board board = boards.get(boardId);
        System.out.println(" Board Id "+board.getId());
        board.getLists().forEach(
                bList -> {
                    StringBuilder str = new StringBuilder();
                    str.append(" \n List Name: ").append(bList.getName());
                    bList.getCards().stream().sorted(Comparator.comparing(Card::getPriority)).forEach(
                            card -> {
//                                    str.append(" \n List Name: ").append(bList.getName());
                                str.append(" \n Card Name: ").
                                        append(card.getName()).
                                        append(" Card Description: ").append(card.getDescription())
                                        .append(" Assigned User : ").append(
                                                card.getAssignedUser() != null ? card.getAssignedUser().getUserName() : " Not Assigned"
                                        );
                            }
                    );
                    //if(bList.getCards().size()==0) str.append(" Empty List: ");
                    System.out.println(str);
                }
        );
    }

    @Override
    public void showBoardByETA(UUID boardId) {
        Board board = boards.get(boardId);
        System.out.println(" Board Id "+board.getId());
        board.getLists().forEach(
                bList -> {
                    StringBuilder str = new StringBuilder();
                    str.append(" \n List Name: ").append(bList.getName());
                    bList.getCards().stream().sorted(Comparator.comparing(Card::getETA)).forEach(
                            card -> {
//                                    str.append(" \n List Name: ").append(bList.getName());
                                str.append(" \n Card Name: ").
                                        append(card.getName()).
                                        append(" Card Description: ").append(card.getDescription())
                                        .append(" Assigned User : ").append(
                                                card.getAssignedUser() != null ? card.getAssignedUser().getUserName() : " Not Assigned"
                                        );
                            }
                    );
                    //if(bList.getCards().size()==0) str.append(" Empty List: ");
                    System.out.println(str);
                }
        );
    }



}
