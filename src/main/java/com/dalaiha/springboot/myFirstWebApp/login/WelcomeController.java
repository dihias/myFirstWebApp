package com.dalaiha.springboot.myFirstWebApp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.lang.reflect.Method;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model){
        model.put("name","didi");
        return "welcome";
    }


}
