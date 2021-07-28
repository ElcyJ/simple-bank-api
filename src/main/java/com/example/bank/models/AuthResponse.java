package com.example.bank.models;

public class AuthResponse {
    private final String token;
    private String name;
    private String email;

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getJwt() {
        return token;
    }

}
