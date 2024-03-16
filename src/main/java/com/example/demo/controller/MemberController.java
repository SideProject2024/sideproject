package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    public final MemberService memberService;

    @GetMapping("/signup")
    public String signupF(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signupP(MemberDTO memberDTO){

        memberService.signup(memberDTO);

        return "redirect:nowPlaying";
    }

    @GetMapping("/login")
    public String loginF(){
        return "login";
    }
}
