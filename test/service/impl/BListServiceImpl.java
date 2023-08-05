package com.subhiagrawal.test.service.impl;

import com.subhiagrawal.test.models.BList;
import com.subhiagrawal.test.models.Card;
import com.subhiagrawal.test.service.BListService;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class BListServiceImpl implements BListService {
    HashMap<UUID, BList> bLists;
    public BListServiceImpl(){
        bLists = new HashMap<>();
    }
    @Override
    public UUID createList(String name) {
        BList list = new BList(name);
        this.bLists.put(list.getId(),list);
        return list.getId();
    }

    @Override
    public void deleteList(UUID listId) throws Exception {
        if(bLists.get(listId)!=null) bLists.remove(listId);
        else throw new Exception("ListId "+listId+" Not preset in Lists of Board");
    }


    @Override
    public void addCardToList(UUID listId, Card card) {
        BList bList = bLists.get(listId);
        if(bList!=null){
            List<Card> cards = bList.getCards();
            cards.add(card);
            bList.setCards(cards);
        }
        bLists.put(listId,bList);
    }

    @Override
    public BList getList(UUID listId) throws Exception {
        BList bList = bLists.get(listId);
        if(bList == null) {
            throw new Exception("No List found with ListId "+listId);
        }
        return bList;
    }

}
