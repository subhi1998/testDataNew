package com.subhiagrawal.test.service;

import com.subhiagrawal.test.models.BList;
import com.subhiagrawal.test.models.Card;

import java.util.UUID;

public interface BListService {
    UUID createList(String name);
    void deleteList(UUID listId) throws Exception;
    void addCardToList(UUID listId, Card card);

    BList getList(UUID listId) throws Exception;
}
