package com.CalorieCounter.CalorieCounter.service;

import com.CalorieCounter.CalorieCounter.model.Account;
import com.CalorieCounter.CalorieCounter.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AccountUserDetailsService implements UserDetailsService {



        @Autowired
        private AccountRepository accountRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Account account = accountRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

            return new User(account.getUsername(), account.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + account.getRole())));
        }
    }


