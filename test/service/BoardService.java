package com.subhiagrawal.test.service;

import com.subhiagrawal.test.models.BList;
import com.subhiagrawal.test.models.User;

import java.util.List;
import java.util.UUID;

public interface BoardService {
    UUID createBoard(String name);
    void deleteBoard(UUID boardId) throws Exception;
    void addUsersToBoard(UUID boardId, List<User> users);
    void addUserToBoard(UUID boardId, User user);
    void addListToBoard(UUID boardId, BList bList);

    void getBoard(UUID boardId);
    void showBoards();

    void showBoardByUser(UUID boardId, String assignedUser);

    void showBoardByCreatedTime(UUID boardId);

    void showBoardByPriority(UUID boardId);

    void showBoardByETA(UUID boardId);
}
