package com.dalaiha.springboot.myFirstWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password){
       boolean isValidPassword = password.equalsIgnoreCase("didi");
        boolean isValidusername = username.equalsIgnoreCase("didi");
        return  isValidusername && isValidPassword;
    }
}
