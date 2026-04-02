package com.hrajaona.library.model;

import java.time.LocalDateTime;

public class RestaurantSnapshot {
    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;
    private LocalDateTime createdAt;

    public RestaurantSnapshot() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public RestaurantSnapshot(String name, String address, String phoneNumber, String emailAddress, LocalDateTime createdAt) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.createdAt = createdAt;
    }
}

