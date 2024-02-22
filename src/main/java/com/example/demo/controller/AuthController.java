package com.example.demo.controller;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*@RestController
@RequiredArgsConstructor
public class AuthController {

    private final HttpSession httpSession;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("testString", "this is from controller");
        return "home";
    }

    @RequestMapping(value = "/home2", method = RequestMethod.GET)
    public String home2(Model model) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("picture", user.getPicture());
        }

        return "home";
    }
}*/

