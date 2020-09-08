package com.example.springboot.controller;

import com.example.springboot.config.ErrorConfig;
import com.example.springboot.service.SessionService;
import com.example.springboot.util.FOP;
import com.example.springboot.util.VerifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@ResponseBody
@Controller
//@RestController
public class SessionController {

//    @PathVariable

//    @RequestHeader
//    @CookieValue

//    @RequestParam
//    @RequestBody

//    @SessionAttribute
//    @ModelAttributeR

    @RequestMapping({"/", "/login.html"})
    public String index() {
        return "login";
    }

    @RequestMapping({"/login", "/login.html"})
    public String loginPage() {
        return "login";
    }

}
