package com.CalorieCounter.CalorieCounter.controller;

import com.CalorieCounter.CalorieCounter.model.Livsmedel;
import com.CalorieCounter.CalorieCounter.service.LivsmedelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/searchLivsmedel")
    public List<Livsmedel> searchLivsmedel(@RequestParam String search){
    return livsmedelService.searchLivsmedel(search);
    }



}
