package com.CalorieCounter.CalorieCounter.controller;

import com.CalorieCounter.CalorieCounter.model.Livsmedel;
import com.CalorieCounter.CalorieCounter.service.LivsmedelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livsmedel")
public class LivsmedelController {

    @Autowired
    private LivsmedelService livsmedelService;


   //TODO if there is no match, return no matches found.
    @PostMapping("/searchLivsmedel")
    public List<Livsmedel> searchLivsmedel(@RequestParam String search){
    return livsmedelService.searchLivsmedel(search);
    }

}
