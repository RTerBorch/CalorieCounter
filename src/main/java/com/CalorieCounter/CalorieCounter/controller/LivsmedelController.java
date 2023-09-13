package com.CalorieCounter.CalorieCounter.controller;

import com.CalorieCounter.CalorieCounter.model.Livsmedel;
import com.CalorieCounter.CalorieCounter.service.LivsmedelService;
import com.CalorieCounter.CalorieCounter.tools.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class LivsmedelController {

    @Autowired
    private LivsmedelService livsmedelService;

    @GetMapping("/")
    public String home(){
        return ("<h1>Welcome</h1>");
    }




    @RequestMapping("/test")
    public String testing(){
        return "Fungerar";
    }

    @RequestMapping("/updateDB")
    public String updateDatabase() {
        livsmedelService.UpdateDB(false);
        return "Database updated successfully.";
    }


    @PostMapping("/searchLivsmedel")
    public List<Livsmedel> searchLivsmedel(@RequestParam String search){
    return livsmedelService.searchLivsmedel(search);
    }



}
