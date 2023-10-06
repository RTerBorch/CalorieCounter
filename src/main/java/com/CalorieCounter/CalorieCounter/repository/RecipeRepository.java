package com.CalorieCounter.CalorieCounter.repository;

import com.CalorieCounter.CalorieCounter.model.Account;
import com.CalorieCounter.CalorieCounter.model.Recept;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recept, Long> {
    Optional<Recept> findByNamn(String namn);
}
