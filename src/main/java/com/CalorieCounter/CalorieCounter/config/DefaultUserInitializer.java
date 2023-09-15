package com.CalorieCounter.CalorieCounter.config;


import com.CalorieCounter.CalorieCounter.model.Account;
import com.CalorieCounter.CalorieCounter.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;




import javax.annotation.PostConstruct;

@Configuration
public class DefaultUserInitializer {

    @Autowired
    private AccountRepository accountRepository;

    @PostConstruct
    public void initUsers() {
        // Check if an admin user already exists
        if (accountRepository.findByUsername("admin").isEmpty()) {
            // Create a new admin user
            Account admin = new Account(null, "admin", "$2a$10$nhEpjymRAFsvpoimCZ92BeQBHSwk01FiYUFPal.vbmMtBjr/1MODO", "ADMIN");
            accountRepository.save(admin);
        }

        // Check if a default user already exists
        if (accountRepository.findByUsername("defaultUser").isEmpty()) {
            // Create a new default user
            Account defaultUser = new Account(null, "user", "$2a$10$WYbfVpShvv0WHspIisedI.FVJHeQ0JuJhGRa778u/jzMuvcqoD3B6", "USER");
            accountRepository.save(defaultUser);
        }
    }
}

