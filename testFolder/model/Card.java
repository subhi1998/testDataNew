package com.subhiagrawal.testFolder.model;

import java.time.LocalDateTime;
import java.util.UUID;
public class Card {

    private UUID cardId;
    private String name;
    private String description;
    private User assignedUser;
    private int priority;
    private LocalDateTime createdTime;
    private LocalDateTime finishedTime;
    private LocalDateTime eta;
    private String status;

    public Card(String name, String description, User assignedUser,
                int priority, LocalDateTime createdTime, LocalDateTime finishedTime,
                LocalDateTime eta, String status) {
        this.cardId = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.assignedUser = assignedUser;
        this.priority = priority;
        this.createdTime = createdTime;
        this.finishedTime = finishedTime;
        this.eta = eta;
        this.status = status;
    }

    public UUID getcardId() {
        return cardId;
    }

    public void setcardId(UUID cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(LocalDateTime finishedTime) {
        this.finishedTime = finishedTime;
    }

    public LocalDateTime getEta() {
        return eta;
    }

    public void setEta(LocalDateTime eta) {
        this.eta = eta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
