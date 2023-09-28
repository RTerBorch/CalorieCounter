package com.CalorieCounter.CalorieCounter.repository;

import com.CalorieCounter.CalorieCounter.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@TestPropertySource(locations = "classpath:application.properties")
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    private Account account1;
    private Account account2;

    @BeforeEach
    public void setUpAccounts() {
        account1 = accountRepository.findById(1L)
                .orElseThrow(() -> new NoSuchElementException("Account not found for ID: 1L"));
        account2 = accountRepository.findById(2L)
                .orElseThrow(() -> new NoSuchElementException("Account not found for ID: 2L"));
    }

    @Test
    public void userIsNotNull() {
        assertThat(account1).isNotNull();
        assertThat(account2).isNotNull();
    }

    @Test
    public void DoesUserHaveCorrectCredentials(){
        assertEquals(1L, (long) account1.getId());
        assertEquals(2L, (long) account2.getId());
    }
}
