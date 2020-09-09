package com.example.springboot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.List;

@RestController
public class HelloController {

    //    @PathVariable

//    @RequestHeader
//    @CookieValue

//    @RequestParam
//    @RequestBody

//    @SessionAttribute
//    @ModelAttribute

    @RequestMapping("/hello")
    public Map<String,Object> hello() {
//        return "Hello Spring Boot!";
        Map<String,Object> res = new Hashtable<>();

        try{
            int a = 5, b = 0;
            System.out.println(a/b);
            System.out.println("I'm find.");
        }catch (Exception e) {
            System.out.println("I'm exception.");
            System.out.println(e.getMessage());
        }finally {
            System.out.println("I'm finally.");
        }

//        new HashSet<>();
//        new HashMap<>();
//        new ConcurrentHashMap<>();

        List<String> animals = new ArrayList<>();
        animals.add("cat");
        animals.add("dog");

        String[] fruits;
        fruits = new String[3];
        fruits[0] = "apple";
        fruits[2] = "orange";

        res.put("animals", animals);
        res.put("fruits", fruits);
        res.put("age",1);
        res.put("age Type",res.get("age").getClass());
        res.put("age Type getCanonicalName",res.get("age").getClass().getCanonicalName());
        res.put("age Type getSimpleName",res.get("age").getClass().getSimpleName());
        res.put("age Type getName",res.get("age").getClass().getName());
        res.put("age Type toString",res.get("age").getClass().toString());

        return res;
    }
}
