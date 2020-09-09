package com.example.springboot.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class SessionController {

    @RequestMapping({"/", "/login.html"})
    public String index() {
        return "login";
    }

    @RequestMapping({"/login", "/login.html"})
    public String loginPage() {
        return "login";
    }

}
