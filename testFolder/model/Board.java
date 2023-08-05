package com.subhiagrawal.testFolder.model;

import java.util.*;
public class Board {

        private UUID  id;
        private String name;
        private Privacy privacy;
        private String url;
        private List<User> memberList;
        private List<ListData> list;

    public Board(String name, String url) {
        this.name = name;
        this.url = url;
        this.id= UUID.randomUUID();
        this.privacy = Privacy.PUBLIC;
        this.memberList = new ArrayList<>();
        this.list = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Privacy getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<User> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<User> memberList) {
        this.memberList = memberList;
    }

    public List<ListData> getList() {
        return list;
    }

    public void setList(List<ListData> list) {
        this.list = list;
    }
}
