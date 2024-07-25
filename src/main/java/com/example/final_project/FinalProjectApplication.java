package com.example.final_project;

import com.example.final_project.model.User;
import com.example.final_project.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.persistence.Entity;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class FinalProjectApplication implements CommandLineRunner {
    private final UserRepository userRepository;

    @Autowired
    public FinalProjectApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FinalProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
