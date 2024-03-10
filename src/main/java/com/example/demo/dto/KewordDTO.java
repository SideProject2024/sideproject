package com.example.demo.dto;

import com.example.demo.entity.KewordEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KewordDTO {

    private int pkid;

    private String movieid;

    private String memberid;

    private String word;

    public static KewordDTO tokeword(KewordEntity kewordEntity){

        return KewordDTO.builder()
                .pkid(kewordEntity.getPkid())
                .movieid(kewordEntity.getMovieid())
                .memberid(kewordEntity.getMemberid())
                .word(kewordEntity.getWord())
                .build();
    }
}
