package com.CalorieCounter.CalorieCounter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Recept {

    @Id
    @GeneratedValue
    private Long id;
    private String namn;

    @ManyToMany
    private List<Livsmedel> ingredients;

    @ManyToMany(mappedBy = "receptList")
    @JsonIgnore
    private List<Account> accounts;

    public Recept(String namn, List<Livsmedel> ingredients, List<Account> accounts) {
        this.namn = namn;
        this.ingredients = ingredients;
        this.accounts = accounts;
    }

    public Recept() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public List<Livsmedel> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Livsmedel> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
