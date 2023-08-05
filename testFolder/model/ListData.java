package com.subhiagrawal.testFolder.model;

import java.util.*;
import java.util.UUID;
public class ListData {

    private UUID id;
    private String name;

    private List<Card> cards;

    public ListData(String name, List<Card> cards) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.cards = cards;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID  id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}

