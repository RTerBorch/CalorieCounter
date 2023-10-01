package com.CalorieCounter.CalorieCounter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    //TODO if admin show admin else user
    @RequestMapping("/")
    public String home(){
     return "<h1>Welcome</h1>";
    }
}
