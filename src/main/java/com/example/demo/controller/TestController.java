package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/users")
@RequiredArgsConstructor
public class TestController {
        @GetMapping("/members/{name}")
            public String findByName(@PathVariable("name") String name) {
            return "Name: " + name;
        }

        @GetMapping("members/{id}/{name}")
        public String findByNameAndId(@PathVariable("id") String id,
                                  @PathVariable("name") String name) {
            return "ID: " + id + ", name: " + name;
        }

}
