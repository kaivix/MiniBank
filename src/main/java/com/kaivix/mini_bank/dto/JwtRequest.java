package com.kaivix.mini_bank.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String password;
    private String username;
}
