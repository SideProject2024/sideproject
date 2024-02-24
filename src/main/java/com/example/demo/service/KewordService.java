package com.example.demo.service;

import com.example.demo.dto.Keword;
import com.example.demo.entity.KewordEntity;
import com.example.demo.repository.KewordIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class KewordService {

    private final KewordIRepository kewordIRepository;

    public void kewordInsert(Keword keword){

        KewordEntity kewordEntity = KewordEntity.tokewordEntity(keword);

        kewordIRepository.save(kewordEntity);
    }

    public List<Keword> kewordListByMovie_id(String movie_id){
        List<KewordEntity> kewordEntityList = kewordIRepository.findByMovieid(movie_id);

        List<Keword> kewordList = new ArrayList<>();

        for (KewordEntity kewordEntity : kewordEntityList){
            Keword keword = Keword.tokeword(kewordEntity);

            kewordList.add(keword);
        }

        return kewordList;
    }

    public List<Map<String,Object>> listcount(){

        List<Map<String, Object>> maps = kewordIRepository.countByMovieId();

        return maps;
    }
}
