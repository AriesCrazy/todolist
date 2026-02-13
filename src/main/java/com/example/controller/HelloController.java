package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        LocalDate date = LocalDate.now();
        String s = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return s;
    }


    @GetMapping("/")
    public String index() {
        return "hello world!";
    }
}
