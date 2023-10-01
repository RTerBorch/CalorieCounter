package com.CalorieCounter.CalorieCounter.controller;

import com.CalorieCounter.CalorieCounter.model.Account;
import com.CalorieCounter.CalorieCounter.model.Livsmedel;
import com.CalorieCounter.CalorieCounter.model.Recept;
import com.CalorieCounter.CalorieCounter.repository.AccountRepository;
import com.CalorieCounter.CalorieCounter.repository.LivsmedelRepository;
import com.CalorieCounter.CalorieCounter.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private Recept activeRecipe;
    @Autowired
    LivsmedelRepository livsmedelRepository;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    AccountRepository accountRepository;


    @PostMapping("/newRecipe")
    public String newRecipe(@RequestParam String recipeName) {
        activeRecipe = new Recept(recipeName, new ArrayList<Livsmedel>(), new ArrayList<Account>());
        return "The recipe " + activeRecipe.getNamn() + " was created.";
    }

    @PostMapping("/selectRecipe")
    public String selectRecipe(@RequestParam Long recipeID) {
        activeRecipe = recipeRepository.findById(recipeID).orElseThrow();
        return "Selected " + activeRecipe.getNamn();
    }

    @PostMapping("/activeRecipe")
    public String activeRecipe() {
        if (activeRecipe != null) {
            return activeRecipe.getNamn() + "is the active recipe.";
        } else return "No active recipe.";

    }

    @PostMapping("/setActiveRecipe")
    public String setActiveRecipe(@RequestParam Long recipeId) {
        activeRecipe = recipeRepository.findById(recipeId).orElseThrow();
        return activeRecipe.getNamn() + " is the activeRecipe";
    }

    @PostMapping("/removeIngredientFromRecipe")
    public String removeIngredient(@RequestParam Long livsmedelID) {
        activeRecipe.getIngredients().remove(livsmedelRepository.findById(livsmedelID).orElseThrow());
        return livsmedelRepository.findById(livsmedelID).orElseThrow().getNamn() + " was removed from " + activeRecipe.getNamn();
    }

    @PostMapping("/addIngredientToRecipe")
    public String addIngredient(@RequestParam Long livsmedelID) {
        Optional<Livsmedel> livsmedelOptional = livsmedelRepository.findById(livsmedelID);
        if (livsmedelOptional.isPresent()) {
            Livsmedel livsmedel = livsmedelOptional.get();
            activeRecipe.getIngredients().add(livsmedel);
            return livsmedel.getNamn() + " was added to " + activeRecipe.getNamn();
        } else {
            return "Product not found.";
        }
    }

    @PostMapping("/addAccountToRecipe")
    public String addAccountToRecipe(@RequestParam Long userID) {
        activeRecipe.getAccounts().add(accountRepository.findById(userID).orElseThrow());
        return accountRepository.findById(userID).orElseThrow().getUsername() + " was connected to " + activeRecipe.getNamn();
    }

    @PostMapping("/saveRecipe")
    public String saveRecipe() {
        recipeRepository.save(activeRecipe);
        return recipeRepository.findById(activeRecipe.getId()).orElseThrow().getNamn() + " recipe was saved.";
    }

    @PostMapping("/allRecipe")
    public List<Recept> allRecipe() {
        return recipeRepository.findAll();
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }


}