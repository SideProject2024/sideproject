package com.example.demo.service;

import com.example.demo.dto.KewordDTO;
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

    public void kewordInsert(KewordDTO keword){

        KewordEntity kewordEntity = KewordEntity.tokeywordEntity(keword);

        kewordIRepository.save(kewordEntity);
    }

    public List<KewordDTO> kewordListByMovie_id(String movie_id){
        List<KewordEntity> kewordEntityList = kewordIRepository.findByMovieid(movie_id);

        List<KewordDTO> kewordList = new ArrayList<>();

        for (KewordEntity kewordEntity : kewordEntityList){
            KewordDTO keword = KewordDTO.tokeword(kewordEntity);

            kewordList.add(keword);
        }

        return kewordList;
    }

    public List<Map<String,Object>> listcount(String movieid){

        List<Map<String, Object>> maps = kewordIRepository.countByWordAndMovieId(movieid);

        return maps;
    }
}
