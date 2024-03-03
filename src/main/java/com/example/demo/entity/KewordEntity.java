package com.example.demo.entity;

import com.example.demo.dto.Keword;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "keword")
@Entity
@NoArgsConstructor
public class KewordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pkid;

    private String movieid;

    @Column(nullable = true)
    private String memberid;

    private String word;


/*    public static KewordEntity tokewordEntity(Keword keword){

        KewordEntity kewordEntity = new KewordEntity();

        kewordEntity.setPkid(keword.getPkid());
        kewordEntity.setMovieid(keword.getMovieid());
        kewordEntity.setMemberid(keword.getMemberid());
        kewordEntity.setWord(keword.getWord());

        return kewordEntity;
    }*/
}
