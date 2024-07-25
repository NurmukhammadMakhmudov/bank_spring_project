package com.example.final_project.service;

import com.example.final_project.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountCheckerService {

    private final UserRepository userRepository;

    public AccountCheckerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isAccountActive(String email) {
        return userRepository.findByEmail(email).get().getIsActive();
    }
}
