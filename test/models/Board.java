package com.subhiagrawal.test.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Board {
    UUID id;
    String name;
    PRIVACY privacy;
    String url;
    List<User> members;
    List<BList> lists;

    List<User> watchedUsers;

    public Board(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.url = "boards/"+this.id;
        this.privacy = PRIVACY.PUBLIC;
        this.members =  new ArrayList<>();
        this.lists =  new ArrayList<>();
        this.watchedUsers = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        for (User user : watchedUsers) {
            user.notify(id, "name of the board modified");
        }
    }

    public PRIVACY getPrivacy() {
        return privacy;
    }

    public void setPrivacy(PRIVACY privacy) {
        this.privacy = privacy;
        for (User user : watchedUsers) {
            user.notify(id, "privacy of the board modified");
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        for (User user : watchedUsers) {
            user.notify(id, "url of the board modified");
        }
    }

    public List<User> getMembers() {
        return members;
    }

    public void setUsers(List<User> members) {
        this.members = members;
        for (User user : watchedUsers) {
            user.notify(id, "Members of the board modified");
        }
    }

    public List<BList> getLists() {
        return lists;
    }

    public void setLists(List<BList> lists) {
        this.lists = lists;
        for (User user : watchedUsers) {
            user.notify(id, "Lists of the board modified");
        }
    }

}
