package com.subhiagrawal.test.models;

import java.util.UUID;

public class Card {
    UUID id;
    String name;
    String description;
    User assignedUser;

    Integer priority;
    Long createdTime;
    Long finishedTime;
    Long ETA;
    String status;


    public Card(String name,String description, Integer priority, Long ETA) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.assignedUser = null;
        this.priority = priority;
        this.createdTime = System.currentTimeMillis();
        this.ETA = ETA;
        this.status = "NEW";
    }

    public UUID getId() {
        return id;
    }

    public synchronized void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public synchronized void setDescription(String description) {
        this.description = description;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public synchronized void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public String getStatus() {
        return status;
    }

    public synchronized void setStatus(String status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public synchronized void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Long getETA() {
        return ETA;
    }

    public Long getCreatedTime() {
        return createdTime;
    }
}
