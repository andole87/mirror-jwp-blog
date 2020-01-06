package com.techcourse.myblog.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class PostAuthenticationToken extends UsernamePasswordAuthenticationToken {

    public PostAuthenticationToken(String email, String password) {
        super(email, password);
    }

    public String getEmail() {
        return (String) super.getPrincipal();
    }

    public String getPassword() {
        return (String) super.getCredentials();
    }
}
