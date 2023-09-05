package com.bookeasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
    @GetMapping("/showLoginPage")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/newBookRegister")
    public String showBookRegister() {
        return "newBookRegister";
    }

    @GetMapping("/adminManage")
    public String showAdminManage() {
        return "adminManage";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }

    @GetMapping("/")
    public String showHome() {
        return "home";
    }
}
