package com.CalorieCounter.CalorieCounter.controller;

import com.CalorieCounter.CalorieCounter.model.Livsmedel;
import com.CalorieCounter.CalorieCounter.model.Recept;
import com.CalorieCounter.CalorieCounter.repository.AccountRepository;
import com.CalorieCounter.CalorieCounter.repository.LivsmedelRepository;
import com.CalorieCounter.CalorieCounter.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recipe") // Ta bort?
public class RecipeController {
    private Recept activeRecipe;
    @Autowired
    LivsmedelRepository livsmedelRepository;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    AccountRepository accountRepository;


    @PostMapping("/newRecipe")
    public String newRecipe(@RequestParam String recipeName){
        activeRecipe = new Recept(recipeName,new ArrayList<>(),new ArrayList<>());
        return "The recipe " + activeRecipe.getNamn() + " was created.";
    }
    @PostMapping("/addIngredientToRecipe")
    public String addIngredient(@RequestParam Long recipeID){
        activeRecipe.getIngredients().add(livsmedelRepository.findById(recipeID).orElseThrow());
        return livsmedelRepository.findById(recipeID).orElseThrow().getNamn() + " was added to " + activeRecipe.getNamn();
    }

    @PostMapping("/addAccountToRecipe")
    public String addAccountToRecipe(@RequestParam Long userID){
        activeRecipe.getAccounts().add(accountRepository.findById(userID).orElseThrow());
        return  accountRepository.findById(userID).orElseThrow().getUsername() + " was connected to " + activeRecipe.getNamn();
    }

    @PostMapping("/saveRecipe")
    public String saveRecipe(){
        recipeRepository.save(activeRecipe);
    return recipeRepository.findById(activeRecipe.getId()).orElseThrow().getNamn() + " recipe was saved.";
    }

    @RequestMapping("/allRecipe")
    public List<Recept> allRecipe(){
        return recipeRepository.findAll();
    }
}