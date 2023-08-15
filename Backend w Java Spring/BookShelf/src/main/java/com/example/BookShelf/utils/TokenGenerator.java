package com.example.BookShelf.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

public class TokenGenerator {

    @Value("${jwt-variables.Key}")
    private String KEY;
    @Value("${jwt-variables.ISSUER}")
    private String ISSUER;
    @Value("${jwt-variables.EXPIRES_ACCES_TOKEN_MINUTE}")
    private Integer EXPIRES_ACCES_TOKEN_MINUTE;

    public String generateToken(Authentication authentication) {
        return null;
    }
}
