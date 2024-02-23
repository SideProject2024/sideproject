package com.example.demo.service;

import com.example.demo.dto.keword;
import com.example.demo.entity.kewordEntity;
import com.example.demo.repository.KewordIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KewordService {

    private final KewordIRepository kewordIRepository;

    public void kewordInsert(keword keword){

        kewordEntity kewordEntity = com.example.demo.entity.kewordEntity.tokewordEntity(keword);

        kewordIRepository.save(kewordEntity);
    }

}
