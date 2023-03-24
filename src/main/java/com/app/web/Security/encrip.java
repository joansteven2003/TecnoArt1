package com.app.web.Security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class encrip {
    public static void main(String[] args) {
        String password = "@Joan2378";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println(hashedPassword);
    }
}
