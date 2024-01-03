package com.kaivix.mini_bank.Controllers;

import com.kaivix.mini_bank.Models.Users;
import com.kaivix.mini_bank.Service.UserService;
import com.kaivix.mini_bank.dto.AppError;
import com.kaivix.mini_bank.dto.JwtRequest;
import com.kaivix.mini_bank.dto.JwtResponse;
import com.kaivix.mini_bank.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class ProfileController {

    private final UserService userService;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public ProfileController(UserService userService, JwtTokenUtils jwtTokenUtils, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtTokenUtils = jwtTokenUtils;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/reg")
    public String reg(Model model){
        model.addAttribute("users", new Users());
        return "regis";
    }

    @PostMapping("/reg")
    public String create(@ModelAttribute("users") Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        userService.save(users);
        return "redirect:/log";
    }

    @GetMapping("/log")
    public String auth(){
        return "auth";
    }


    @PostMapping("/log")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest ){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            System.out.println(authRequest.getPassword());
        }
        catch (BadCredentialsException e){
          return new  ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(), "Неверный логин или пароль"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }


}
