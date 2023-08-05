package com.subhiagrawal.test.service.impl;

import com.subhiagrawal.test.models.Card;
import com.subhiagrawal.test.models.User;
import com.subhiagrawal.test.service.CardService;

import java.util.HashMap;
import java.util.UUID;

public class CardServiceImpl implements CardService {
    HashMap<UUID, Card> listOfCards;
    public CardServiceImpl(){
        listOfCards = new HashMap<>();
    }
    @Override
    public UUID createCard(String name,String description, Integer priority, Long ETA) {
        Card card = new Card(name,description, priority, ETA);
        this.listOfCards.put(card.getId(),card);
        return card.getId();
    }

    @Override
    public void deleteCard(UUID cardId) throws Exception {
        if(listOfCards.get(cardId)!=null) listOfCards.remove(cardId);
        else throw new Exception("Card "+cardId+" Not preset in List of Cards");
    }

    @Override
    public void assignCardTOUser(UUID cardId, User user) {
        Card card =  listOfCards.get(cardId);
        if(card!=null){
            card.setAssignedUser(user);
        }
    }

    @Override
    public void getCard(UUID cardId) {
        StringBuilder str = new StringBuilder();
        Card card = listOfCards.get(cardId);
        str.append(" \n Card Name: ").
                append(card.getName()).
                append(" Card Description: ").append(card.getDescription())
                .append(" Assigned User : ").append(
                        card.getAssignedUser()!=null?card.getAssignedUser().getUserName():" Not Assigned");
        System.out.println(str);
    }

}
