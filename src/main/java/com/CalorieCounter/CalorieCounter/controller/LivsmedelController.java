package com.CalorieCounter.CalorieCounter.controller;

import com.CalorieCounter.CalorieCounter.model.Livsmedel;
import com.CalorieCounter.CalorieCounter.service.LivsmedelService;
import com.CalorieCounter.CalorieCounter.tools.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/CalorieCounter")
public class LivsmedelController {

    @Autowired
    private LivsmedelService livsmedelService;

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
