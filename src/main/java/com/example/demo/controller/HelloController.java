package com.example.demo.controller;

import com.example.demo.service.CRDTService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/crdt")
public class HelloController {

    //수정본
    private CRDTService crdtService;

    private SimpMessagingTemplate messagingTemplate;

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @ResponseBody
    @PostMapping("/increment")
    public void increment(@RequestParam String key) {
        crdtService.increment(key);
        messagingTemplate.convertAndSend("/topic/crdt-updates", crdtService.getCRDTMap());
    }

    @ResponseBody
    @GetMapping("/get")
    public Map<String, Integer> getCRDTMap() {
        return crdtService.getCRDTMap();
    }
}