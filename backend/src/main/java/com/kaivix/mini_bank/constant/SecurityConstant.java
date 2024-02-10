package com.kaivix.mini_bank.constant;

import org.springframework.beans.factory.annotation.Value;

public class SecurityConstant {

    @Value("${jwt.lifetime}")
    public static String EXPIRATION_TIME;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String AUTHORITIES = "authorities";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
    public static final String GET_ARRAYS_LLC = "Get Arrays, LLC";
    public static final String GET_ARRAYS_ADMINISTRATION = "User Management Portal";
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token can`t be verified";
    public static final String FORBIDDEN_MESSAGE = "You need to log in to access this page";
    public static final String ACCES_DENNIED_MESSAGE = "You don`t have permission to access this page";
    public static final String[] PUBLIC_URLS = {"/user/login", "/user/resetpincode/**", "/user/register", "/user/image/**"};


}
