package com.CalorieCounter.CalorieCounter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private boolean admin;

    public Account(Long id, String username, String password, boolean admin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.admin = admin;
    }
}
