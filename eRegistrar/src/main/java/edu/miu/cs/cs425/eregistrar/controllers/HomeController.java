package edu.miu.cs.cs425.eregistrar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/","/home", "/eregistrar"})
    public String displayHomepage(){
       return "public/index";
    }

    @GetMapping("/test")
    public String displayTest(){
        return "test";
    }
}
