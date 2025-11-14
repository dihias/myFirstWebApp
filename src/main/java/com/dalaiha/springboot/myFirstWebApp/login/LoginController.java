package com.dalaiha.springboot.myFirstWebApp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


private Logger logger= LoggerFactory.getLogger(getClass());
    @RequestMapping("login")
    //@ResponseBody
    public String goToLoginPage(@RequestParam String name, ModelMap model){
        //System.out.println("request param value is "+ name);
        model.put("name",name);
        //printed at debug level
        logger.debug("the request param is {} ",name);

        //printed at info level
        logger.info("the request param is {} ",name);

        //printed at warn level
        logger.warn("the request param is {} ",name);
        return "login";
    }
}
