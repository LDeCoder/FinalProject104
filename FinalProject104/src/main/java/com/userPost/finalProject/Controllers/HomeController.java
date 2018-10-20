package com.userPost.finalProject.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.userPost.finalProject.Models.Post;

import org.springframework.ui.Model;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(Model model) {
    	model.addAttribute("post", new Post());
        return "home";
    }

    @GetMapping("/membersOnly")
    public String getMembersOnly() {
        return "membersOnly";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
}