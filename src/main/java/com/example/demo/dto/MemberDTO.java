package com.example.demo.dto;

import com.example.demo.entity.MemberEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDTO {
    private Long memberID;
    private String email;
    private String password;
    private String name;
    private String profile;
    private String role;

    private static MemberDTO toMemberDTO(MemberEntity memberEntity){
        return MemberDTO.builder()
                .memberID(memberEntity.getMemberID())
                .email(memberEntity.getEmail())
                .password(memberEntity.getPassword())
                .name(memberEntity.getName())
                .profile(memberEntity.getProfile())
                .role(memberEntity.getRole())
                .build();
    }
}
