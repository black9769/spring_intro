package com.study.intro_spring.service;

import com.study.intro_spring.domain.Member;
import com.study.intro_spring.repo.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }


    public List<Member> findMember() {
        return memberRepository.findAll();
    }

}
