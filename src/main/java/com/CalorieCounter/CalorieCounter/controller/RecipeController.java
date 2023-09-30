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
    private Recept activeRecept;
    @Autowired
    LivsmedelRepository livsmedelRepository;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    AccountRepository accountRepository;


    @PostMapping("/newRecipe")
    public String newRecipe(@RequestParam String recipeName){
        activeRecept = new Recept(recipeName,new ArrayList<>(),new ArrayList<>());
        return "The recipe " + activeRecept.getNamn() + " was created.";
    }
    @PostMapping("/addIngredientToRecipe")
    public String addIngredient(@RequestParam Long recipeId){
        activeRecept.getIngredients().add(livsmedelRepository.findById(recipeId).orElseThrow());
        return livsmedelRepository.findById(recipeId).orElseThrow().getNamn() + " was added to " + activeRecept.getNamn();
    }


    /*
    @PostMapping("/newRecipe")
    public String newRecipe(@RequestParam String inputName) {
        List<Livsmedel> livsmedelList = new ArrayList<>();
        List<Account> accounts = new ArrayList<>();
        String receptNamn = inputName.toLowerCase();

        Recept recept = new Recept(receptNamn, livsmedelList, accounts);
        System.out.println("recept " + recept.getNamn() + " " +receptNamn.toString());
        recipeRepository.save(recept);
        return "Recipe " + receptNamn + " created.";
    }

     */

    @RequestMapping("/allRecipe")
    public List<Recept> allRecipe(){
        return recipeRepository.findAll();
    }

    @RequestMapping("/test")
    public String test(){
        return ("<h1>Welcome to recipe</h1>");
    }

    @RequestMapping("/addItem")
    public void addItem(@RequestParam Long livsmedelId, @RequestParam String inputName) {

        Recept recipe = recipeRepository.findByNamn(inputName.toLowerCase())
                .orElseThrow();

        Livsmedel livsmedel = livsmedelRepository.findById(livsmedelId)
                .orElseThrow();

        recipe.getIngredients().add(livsmedel);

        recipeRepository.save(recipe);
    }


}