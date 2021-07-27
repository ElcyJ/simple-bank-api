package com.example.bank.models;

public class AuthResponse {
    public AuthResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    private final String jwt;

}
