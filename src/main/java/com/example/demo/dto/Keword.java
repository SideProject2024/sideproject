package com.example.demo.dto;

import com.example.demo.entity.KewordEntity;
import lombok.Data;

@Data
public class Keword {

    private int pkid;

    private String movieid;

    private String memberid;

    private String word;

    public static Keword tokeword(KewordEntity kewordEntity){

        Keword keword = new Keword();

        keword.setPkid(kewordEntity.getPkid());
        keword.setMovieid(kewordEntity.getMovieid());
        keword.setMemberid(kewordEntity.getMemberid());
        keword.setWord(kewordEntity.getWord());

        return keword;
    }
}
