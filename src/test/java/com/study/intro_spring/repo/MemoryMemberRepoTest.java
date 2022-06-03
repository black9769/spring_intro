package com.study.intro_spring.repo;

import com.study.intro_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepoTest {

    MemoryMemberRepo repo = new MemoryMemberRepo();

    @AfterEach
    public void afterEach() {
        repo.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("black9769");

        repo.save(member);

        Member result = repo.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }


    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("black9769");
        repo.save(member1);

        Member member2 = new Member();
        member2.setName("black69");
        repo.save(member2);

        Member result = repo.findByName("black9769").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("black9769");
        repo.save(member1);

        Member member2 = new Member();
        member2.setName("black69");
        repo.save(member2);

        List<Member> result = repo.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
