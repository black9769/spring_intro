package com.study.intro_spring.service;

import com.study.intro_spring.domain.Member;
import com.study.intro_spring.repo.MemoryMemberRepo;
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
    MemoryMemberRepo memoryMemberRepo;


    @BeforeEach
    public void beforeEach(){
        memoryMemberRepo = new MemoryMemberRepo();
        memberService = new MemberService(memoryMemberRepo);
    }

    @AfterEach
    public void afterEach() {
        memoryMemberRepo.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_가입() {
        //given
        Member member1 = new Member();
        member1.setName("hello");

        //given
        Member member2 = new Member();
        member2.setName("hello");

        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, ()-> memberService.join(member2));


    }


    @Test
    void findMembers() {


    }

    @Test
    void findOne() {
    }
}