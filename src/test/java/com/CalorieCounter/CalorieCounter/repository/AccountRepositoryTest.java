package com.CalorieCounter.CalorieCounter.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.CalorieCounter.CalorieCounter.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@TestPropertySource(locations= "classpath:application.properties")
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void theRightUserIsFound() {
        Optional<Account> accountOptional = accountRepository.findById(1L);
        if(accountOptional.isPresent()) {
            Account account = accountOptional.get();
            assertEquals(accountRepository.findById(1L).orElseThrow().getUsername(),"testUser1");
             assertEquals (accountRepository.findById(1L).orElseThrow().getPassword(),"password1");
        } else {
            System.out.println("ERROR ");
        }

    }
}
