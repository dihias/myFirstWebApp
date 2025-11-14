package com.dalaiha.springboot.myFirstWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SayHelloControler {

    @RequestMapping("hello")
    @ResponseBody
    public String sayHello(){
        return "Hi there, what's up dhinna ?";
    }

    @RequestMapping("hello-html")
    @ResponseBody
    public String sayHelloHtml(){
        StringBuffer sb= new StringBuffer();
        sb.append("<!DOCTYPE html>");
        sb.append("<head>");
        sb.append("<title>Document</title>");
        sb.append("</head>");
        sb.append(" <body> <h1>Hi there, what's up dhinna ehm?</h1></body></html>");
        return sb.toString();
    }

    @RequestMapping("hello-jsp")
    //@ResponseBody
    public String sayHelloJsp(){
        return "sayHello";
    }


}
