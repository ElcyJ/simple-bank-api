package com.example.bank.models;

import javax.persistence.*;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String number;
    private double balance;
    // @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @ManyToOne()
    @JoinColumn(name="bank_user")
    private User user;

    public Account() {
    }

    public Account(String number) {
        this.number = number;
    }

    public Account(String number, double balance, User user) {
        this.number = number;
        this.balance = balance;
        this.user = user;
    }

    public Account(long id, String number, double balance, User user) {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
