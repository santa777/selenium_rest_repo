package com.practice.practice2026.apiTests.san2026;

public class User {

    private String name;
    private String gender;
    private String email;
    private String status;

    // Constructors
    public User(String name, String gender, String email, String status) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.status = status;
    }

    public User() {
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    // Setters (Crucial for PATCH so you can set only one field)
    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
