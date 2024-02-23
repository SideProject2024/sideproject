package com.example.demo.entity;

import com.example.demo.dto.keword;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "keword")
@Entity
@NoArgsConstructor
public class kewordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pkid;

    private String movie_id;

    private String member_id;

    private String word;


    public static kewordEntity tokewordEntity(keword keword){

        kewordEntity kewordEntity = new kewordEntity();

        kewordEntity.setPkid(keword.getPkid());
        kewordEntity.setMovie_id(keword.getMovie_id());
        kewordEntity.setMember_id(keword.getMember_id());
        kewordEntity.setWord(keword.getWord());

        return kewordEntity;
    }
}
