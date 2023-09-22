package com.study.intro_spring.service;

import com.study.intro_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional

class MemberServiceTest {

    MemberService memberService;


    @Test
    void 회원가입() {

    }

    @Test
    void 중복_회원_가입() {



    }


    @Test
    void findMembers() {


    }

    @Test
    void findOne() {
    }
}