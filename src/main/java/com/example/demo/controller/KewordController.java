package com.example.demo.controller;

import com.example.demo.dto.KewordDTO;
import com.example.demo.service.KewordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    public String kewordInsert(KewordDTO keword){

        kewordService.kewordInsert(keword);

        return "success";
    }

    @ResponseBody
    @PostMapping("/listByMovieID")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<KewordDTO> listByMovieID(String movieID){

        List<KewordDTO> kewordList= kewordService.kewordListByMovie_id(movieID);

        return kewordList;
    }

    @ResponseBody
    @PostMapping("/countByMovieID")
    public List<Map<String, Object>> countByMovieID(String movieID){

        List<Map<String, Object>> listcount = kewordService.listcount(movieID);

        return listcount;
    }
}
