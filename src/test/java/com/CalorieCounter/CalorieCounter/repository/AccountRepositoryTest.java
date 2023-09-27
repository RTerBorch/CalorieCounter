package com.CalorieCounter.CalorieCounter.repository;

import com.CalorieCounter.CalorieCounter.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@TestPropertySource(locations= "classpath:application.properties")
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;


    @Test

        public void theRightUserIsFound() {
        System.out.println(accountRepository.findById(1L));

            Optional<Account> accountOptional = accountRepository.findById(1L);
            assertThat(accountOptional).isPresent(); // Assert that the account is present

            Account account = accountOptional.get();
            assertThat(account.getUsername()).isEqualTo("testUser1");
            assertThat(account.getPassword()).isEqualTo("password1");

        }


    }

