package com.example.demo.entity;

import com.example.demo.dto.MemberDTO;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
@Builder
@Entity
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor

public class MemberEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberID;
    private String Email;
    private String Password;
    private String Name;
    @Column(nullable = true)
    private String Profile;
    private String Role;

    private static MemberEntity toMemberEntity(MemberDTO memberDTO){
        return MemberEntity.builder()
                .memberID(memberDTO.getMemberID())
                .Email(memberDTO.getEmail())
                .Password(memberDTO.getPassword())
                .Name(memberDTO.getName())
                .Profile(memberDTO.getProfile())
                .Role(memberDTO.getRole())
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(this.Role));
    }

    @Override
    public String getUsername() {
        return this.Email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
