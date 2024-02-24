package com.example.demo.controller;

import com.example.demo.dto.Keword;
import com.example.demo.service.KewordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class KewordController {

    private final KewordService kewordService;
    @ResponseBody
    @PostMapping("/kewordInsert")
    public String kewordInsert(Keword keword){

        kewordService.kewordInsert(keword);

        return "success";
    }

    @ResponseBody
    @PostMapping("/listByMovieID")
    public List<Keword> listByMovieID(String movieID){

        List<Keword> kewordList= kewordService.kewordListByMovie_id(movieID);

        return kewordList;
    }

    @ResponseBody
    @PostMapping("/countByMovieID")
    public List<Map<String, Object>> countByMovieID(){

        List<Map<String, Object>> listcount = kewordService.listcount();

        return listcount;
    }
}
