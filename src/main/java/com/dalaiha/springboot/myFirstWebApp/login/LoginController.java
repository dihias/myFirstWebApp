package com.dalaiha.springboot.myFirstWebApp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Method;

@Controller
public class LoginController {
private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    //on gere uniquement les requettes GET avec ca
    @RequestMapping(value="login", method = RequestMethod.GET)
    //@ResponseBody
    public String goToLoginPage(){

        return "login";
    }

    //on gere uniquement les requettes POST avec ca
    @RequestMapping(value="login", method = RequestMethod.POST)
    //@ResponseBody
    public String goTowELCOMEPage(@RequestParam String name, @RequestParam String password, ModelMap model){
        model.put("name",name);
        if (authenticationService.authenticate(name,password)){
        return "welcome";}
        model.put("error","false password or username");
        return "login";
    }
}
