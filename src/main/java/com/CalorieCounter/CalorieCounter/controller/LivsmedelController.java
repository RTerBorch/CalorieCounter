package com.CalorieCounter.CalorieCounter.controller;

import com.CalorieCounter.CalorieCounter.service.LivsmedelService;
import com.CalorieCounter.CalorieCounter.tools.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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




}
