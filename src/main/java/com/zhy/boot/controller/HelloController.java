package com.zhy.boot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @RequestMapping("/1.jpg")
    public String Hello() {
        return "aaaa";
    }

    @PostMapping("/user")
    public String saveUser() {
        return "POST-user";
    }

//    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @PutMapping("/user")
    public String editUser() {
        return "PUT-user";
    }

//    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String deleteUser() {
        return "DELETE-user";
    }

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser() {
        return "GET-user";
    }

}
