package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class CRDTService {
    private final Map<String, Integer> crdtMap = new HashMap<>();

    public void increment(String key) {
        crdtMap.putIfAbsent(key, 0);
        int value = crdtMap.get(key);
        crdtMap.put(key, value + 1);
    }

    public Map<String, Integer> getCRDTMap() {
        return new HashMap<>(crdtMap);
    }
}
