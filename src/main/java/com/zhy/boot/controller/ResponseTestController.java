package com.zhy.boot.controller;

import com.zhy.boot.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ResponseTestController {

    @ResponseBody
    @GetMapping("/person")
    public Person getPerson() {
        Person person = new Person();
        person.setAge(23);
        person.setBirth(new Date());
        person.setName("李四");
        System.out.println("hello");
        return person;
    }
}


