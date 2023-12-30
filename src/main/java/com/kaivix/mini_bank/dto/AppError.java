package com.kaivix.mini_bank.dto;


import lombok.Data;

import java.util.Date;

@Data
public class AppError {
    private Integer status;
    private String message;
    private Date timestamp;

    public AppError(int status, String message){
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
