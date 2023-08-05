package com.subhiagrawal.testFolder.model;

import java.util.UUID;

public class User {

    private UUID userId;
    private String name;
    private String email;

    public User(String name, String email){

        this.userId = UUID.randomUUID();
        this.name = name;
        this.email = email;

    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

