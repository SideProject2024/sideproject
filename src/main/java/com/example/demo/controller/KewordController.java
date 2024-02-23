package com.example.demo.controller;

import com.example.demo.dto.keword;
import com.example.demo.service.KewordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class KewordController {

    private final KewordService kewordService;
    @ResponseBody
    @PostMapping("/kewordInsert")
    public String kewordInsert(keword keword){

        kewordService.kewordInsert(keword);

        return "success";
    }
}
