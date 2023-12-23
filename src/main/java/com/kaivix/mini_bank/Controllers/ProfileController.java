package com.kaivix.mini_bank.Controllers;

import com.kaivix.mini_bank.Models.Users;
import com.kaivix.mini_bank.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class ProfileController {

    private final UserService userService;
    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/reg")
    public String reg(Model model){
        model.addAttribute("users", new Users());
        return "regis";
    }

    @PostMapping()
    public String create(@ModelAttribute("users") Users users) {
        userService.save(users);
        return "redirect:/";
    }

}
