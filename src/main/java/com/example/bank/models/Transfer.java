package com.example.bank.models;

import javax.persistence.*;

@Entity
@Table
public class Transfer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String sourceAccountNumber;
    private String destinationAccountNumber;
    private double amount;
    @ManyToOne()
    @JoinColumn(name="bank_user")
    private User userTransfer;

    public Transfer() {
    }

    public Transfer(String sourceAccountNumber, String destinationAccountNumber, double amount, User userTransfer) {
        this.sourceAccountNumber = sourceAccountNumber;
        this.destinationAccountNumber = destinationAccountNumber;
        this.amount = amount;
        this.userTransfer = userTransfer;
    }

    public Transfer(long id, String sourceAccountNumber, String destinationAccountNumber, double amount, User userTransfer) {
        this.id = id;
        this.sourceAccountNumber = sourceAccountNumber;
        this.destinationAccountNumber = destinationAccountNumber;
        this.amount = amount;
        this.userTransfer = userTransfer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public void setSourceAccountNumber(String sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }

    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public void setDestinationAccountNumber(String destinationAccountNumber) {
        this.destinationAccountNumber = destinationAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUserTransfer() {
        return userTransfer;
    }

    public void setUserTransfer(User userTransfer) {
        this.userTransfer = userTransfer;
    }


}
