package com.example.demo.dto;

import com.example.demo.entity.kewordEntity;
import lombok.Data;

@Data
public class keword {

    private int pkid;

    private String movie_id;

    private String member_id;

    private String word;

    public static keword tokeword(kewordEntity kewordEntity){

        keword keword = new keword();

        keword.setPkid(kewordEntity.getPkid());
        keword.setMovie_id(kewordEntity.getMovie_id());
        keword.setMember_id(kewordEntity.getMember_id());
        keword.setWord(kewordEntity.getWord());

        return keword;
    }
}
