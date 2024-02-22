package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;



@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Test
    public void 회원가입() throws Exception {
        // given (이렇게 주어졌을 때)
        Member member = new Member();
        member.setName("Cha");

        // when (이렇게 하면)
        Long savedId = memberService.join(member);
        // then (이렇게 된다)
        asserE


    }

    @Test
    public void 중복_회원_예외() throws Exception {
    // given

    // when

    // then
    }

}