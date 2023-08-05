package com.subhiagrawal.test.service;

import com.subhiagrawal.test.models.User;

import java.util.UUID;

public interface CardService {
    UUID createCard(String name,String description, Integer priority, Long ETA);
    void deleteCard(UUID cardId) throws Exception;
    void assignCardTOUser(UUID cardId, User user);

    void getCard(UUID cardId);
}
