package com.example.controller;

import com.example.entity.TodoEntity;
import com.example.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private TodoMapper todoMapper;

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

    @GetMapping("/test")
    public String test() {
        List<TodoEntity> todoEntities = todoMapper.selectList(null);
        return todoEntities.toString();
    }
}
