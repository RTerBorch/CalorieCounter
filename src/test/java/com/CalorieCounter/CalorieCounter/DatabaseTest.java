package com.CalorieCounter.CalorieCounter;

import com.CalorieCounter.CalorieCounter.model.Account;
import com.CalorieCounter.CalorieCounter.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DatabaseTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void whenFindByUsername_thenReturnAccount() {
        // when
        Optional<Account> foundOpt = accountRepository.findByUsername("testUser1");

        // then
        assertThat(foundOpt).isPresent();
        assertThat(foundOpt.get().getUsername()).isEqualTo("testUser1");
        assertThat(foundOpt.get().getRole()).isEqualTo("ADMIN");
    }
}
