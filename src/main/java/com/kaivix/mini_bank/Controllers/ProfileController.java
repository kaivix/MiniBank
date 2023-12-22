package com.kaivix.mini_bank.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/user")
public class ProfileController {

    @GetMapping("/registration")
    private String registration(){
        return "registration";
    }
}
