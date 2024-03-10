package com.example.demo.entity;

import com.example.demo.dto.KewordDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Table(name = "keword")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class KewordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pkid;

    private String movieid;

    @Column(nullable = true)
    private String memberid;

    private String word;


    public static KewordEntity tokeywordEntity(KewordDTO kewordDTO){

        return KewordEntity.builder()
                .pkid(kewordDTO.getPkid())
                .movieid(kewordDTO.getMovieid())
                .memberid(kewordDTO.getMemberid())
                .word(kewordDTO.getWord())
                .build();
    }
}
