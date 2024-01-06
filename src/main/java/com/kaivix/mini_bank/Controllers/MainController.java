package com.kaivix.mini_bank.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    private String Welcome(){
        System.out.println("Show welcome page");
        return "welcome";
    }


}
