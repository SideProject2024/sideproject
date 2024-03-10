package com.example.demo.dto;

import com.example.demo.entity.MemberEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDTO {
    private Long memberID;
    private String Email;
    private String Password;
    private String Name;
    private String Profile;
    private String Role;

    private static MemberDTO toMemberDTO(MemberEntity memberEntity){
        return MemberDTO.builder()
                .memberID(memberEntity.getMemberID())
                .Email(memberEntity.getEmail())
                .Password(memberEntity.getPassword())
                .Name(memberEntity.getName())
                .Profile(memberEntity.getProfile())
                .Role(memberEntity.getRole())
                .build();
    }
}
