package com.example.yeshteryToken.model;

public class AuthanticationResponse {
    private final String jwt;

    public AuthanticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
