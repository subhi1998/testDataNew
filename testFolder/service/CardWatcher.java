package com.subhiagrawal.testFolder.service;

import java.util.UUID;
import com.subhiagrawal.testFolder.model.User;
import java.util.*;
public class CardWatcher {

    private UUID cardId;
    private List<User> watchers;

    public CardWatcher(UUID cardId) {
        this.cardId = cardId;
        this.watchers = new ArrayList<>();
    }

    public void addWatcher(User user) {
        if (!watchers.contains(user)) {
            watchers.add(user);
        }
    }

    public void removeWatcher(User user) {
        watchers.remove(user);
    }

    public void notifyWatchers(String message) {
        for (User watcher : watchers) {
            System.out.println("Notification to " + watcher.getName() + ": " + message);
        }
    }

}
