package com.example.bank.models;

public class TransferResponse {
    private double amount;
    private String sourceAccountNumber;
    private String destinationAccountNumber;
    private User userTranfer;

    public TransferResponse(double amount, String sourceAccountNumber, String destinationAccountNumber, User userTranfer) {
        this.amount = amount;
        this.sourceAccountNumber = sourceAccountNumber;
        this.destinationAccountNumber = destinationAccountNumber;
        this.userTranfer = userTranfer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public User getUserTranfer() {
        return userTranfer;
    }

    public void setUserTranfer(User userTranfer) {
        this.userTranfer = userTranfer;
    }


}
