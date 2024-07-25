package com.example.final_project.exaptions;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsernameWasUsed extends IllegalArgumentException {


    public UsernameWasUsed(String s) {
        super(s);
    }
}
