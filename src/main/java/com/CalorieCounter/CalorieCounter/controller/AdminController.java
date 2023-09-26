package com.CalorieCounter.CalorieCounter.controller;


import com.CalorieCounter.CalorieCounter.model.Account;
import com.CalorieCounter.CalorieCounter.model.Recept;
import com.CalorieCounter.CalorieCounter.repository.AccountRepository;
import com.CalorieCounter.CalorieCounter.repository.LivsmedelRepository;
import com.CalorieCounter.CalorieCounter.service.LivsmedelService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    LivsmedelRepository livsmedelRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    private LivsmedelService livsmedelService;


    @PostMapping("/addAccount")
    public String addUser(){
        return "user added";
    }

    @RequestMapping("/updateDB")
    public String updateDatabase() {
        livsmedelService.UpdateDB(false);
        return "Database updated successfully.";
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

    /*
    @RequestMapping(value = "/newRecipe", method = RequestMethod.GET)
    @ResponseBody
    public List<Recept> createRecipe(Principal principal) {
        Account account = accountRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

      //  account.getReceptList();

        return account.getReceptList();
    }

     */



}
