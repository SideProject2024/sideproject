package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.MemberEntity;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public void signup(MemberDTO memberDTO){

        memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
        memberDTO.setRole("user");
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<MemberEntity> Bymember = memberRepository.findByEmail(username);

        MemberEntity memberEntity =Bymember.orElseThrow(() -> new UsernameNotFoundException("등록되지 않은 ID입니다."));

        return User.builder()
                .username(memberEntity.getEmail())
                .password(memberEntity.getPassword())
                .roles(memberEntity.getRole())
                .build();
    }
}
