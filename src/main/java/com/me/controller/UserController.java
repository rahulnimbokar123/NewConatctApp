package com.me.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    // user dashboard

    @RequestMapping(value = "/dashboard" )
    public String userDashboard() {

        return "user/dashboard";
    }

    // user profile
    @RequestMapping(value = "/profile")
    public String userProfile() {

        return "user/profile";
    }

}
