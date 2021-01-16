package com.don.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;

@RestController
@RequestMapping("/v2")
public class Controller {

    @GetMapping("/hello")
    public String hello() {

        System.out.println("hello world .. time is :" + DateFormat.getDateInstance().toString());
        return "hello world . I am Okay ...";
    }
}
