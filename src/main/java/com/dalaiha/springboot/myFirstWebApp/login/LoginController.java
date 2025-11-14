package com.dalaiha.springboot.myFirstWebApp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {



    @RequestMapping("login")
    //@ResponseBody
    public String goToLoginPage(@RequestParam String name, ModelMap model){
        //System.out.println("request param value is "+ name);
        model.put("name",name);

        return "login";
    }
}
