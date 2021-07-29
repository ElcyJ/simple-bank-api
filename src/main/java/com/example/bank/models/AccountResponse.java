package com.example.bank.models;

public class AccountResponse {
    private String number;
    private double balance;
    private User user;

    public AccountResponse(String number, double balance, User user) {
        this.number = number;
        this.balance = balance;
        this.user = user;
    }

    public AccountResponse(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
