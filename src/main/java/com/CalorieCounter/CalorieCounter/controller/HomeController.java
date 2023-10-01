package com.CalorieCounter.CalorieCounter.controller;

import com.CalorieCounter.CalorieCounter.model.Account;
import com.CalorieCounter.CalorieCounter.repository.AccountRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
public class HomeController {

    @Autowired
    AccountRepository accountRepository;

   @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Principal principal, Model model) {
        Optional<Account> optionalAccount = accountRepository.findByUsername(principal.getName());
        if (optionalAccount.isEmpty()) {
            return "redirect:/error/404"; // Omdirigera till 404-felvyn
        }
        Account account = optionalAccount.get();
        if (account.getRole().equalsIgnoreCase("ADMIN")) {
            return "admin-menu"; // Visa admin-menyn
        } else {
            model.addAttribute("username", account.getUsername());
            return "user-welcome"; // Visa användarens välkomstvy
        }
    }

}
