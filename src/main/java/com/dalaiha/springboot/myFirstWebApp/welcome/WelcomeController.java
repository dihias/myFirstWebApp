package com.dalaiha.springboot.myFirstWebApp.welcome;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model, Authentication authentication){
    // public String goToWelcomePage(ModelMap model, Authentication authentication){ : in this case we won't need getLoggedInUsername , the bean will be directly injected by spring
        model.put("name", authentication.getName());
        model.put("name", getLoggedInUsername());
        return "welcome";
    }

    private String getLoggedInUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       return authentication.getName();
    }


}
