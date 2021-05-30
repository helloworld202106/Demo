package com.hello.world.demo.controller;

import com.hello.world.demo.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    Person person;

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @RequestMapping("/person")
    public Person person(){
        return person;
    }

    @GetMapping("/user")
    public String hi(){
        return "user";
    }

}
