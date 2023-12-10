package com.CalorieCounter.CalorieCounter.config;


import com.CalorieCounter.CalorieCounter.model.Account;
import com.CalorieCounter.CalorieCounter.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class DefaultUserInitializer {

    @Autowired
    private AccountRepository accountRepository;

    @Value("${SEC_ADMIN_USERNAME}")
    private String adminUsername;

    @Value("${SEC_ADMIN_PASSWORD_HASH}")
    private String adminPasswordHash;

    @Value("${SEC_USERNAME}")
    private String username;

    @Value("${SEC_PASSWORD_HASH}")
    private String passwordHash;

    @PostConstruct
    public void initUsers() {
        // Check if an admin user already exists
        if (accountRepository.findByUsername("admin").isEmpty()) {
            // Create a new admin user
            Account admin = new Account(null, adminUsername, adminPasswordHash, "ADMIN");
            accountRepository.save(admin);
        }

        // Check if a default user already exists
        if (accountRepository.findByUsername("user").isEmpty()) {
            // Create a new default user
            Account defaultUser = new Account(null, username, passwordHash, "USER");
            accountRepository.save(defaultUser);
        }
    }
}

