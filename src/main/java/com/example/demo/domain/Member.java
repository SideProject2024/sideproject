package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")

    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<MainContents> mainContents = new ArrayList<>();
}
