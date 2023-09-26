package com.CalorieCounter.CalorieCounter.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.CalorieCounter.CalorieCounter.model.Account;
import com.CalorieCounter.CalorieCounter.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void whenFindByUsername_thenReturnAccount() {
        // given
        Account alex = new Account(null, "alex", "password123", "USER");
        entityManager.persist(alex);
        entityManager.flush();

        // when
        Optional<Account> foundOpt = accountRepository.findByUsername(alex.getUsername());

        // then
        assertThat(foundOpt).isPresent();
        assertThat(foundOpt.get().getUsername()).isEqualTo(alex.getUsername());
    }
}
