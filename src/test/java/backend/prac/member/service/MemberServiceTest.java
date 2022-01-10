package backend.prac.member.service;

import backend.prac.member.domain.Member;
import backend.prac.member.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class memberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;


    @DisplayName("회원가입시 id가 1씩 증가합니다.")
    @Test
    public void save() throws Exception {
        // given
        Member member1 = new Member(null, "아무개", "닉네임", "asd12", "123");
        Member member2 = new Member(null, "개뭉아", "임네닉", "12ㅁㄴㅇ", "444");

        // when
        Member saveMember1 = memberRepository.save(member1);
        Member saveMember2 = memberRepository.save(member2);

        // then
        Assertions.assertThat(saveMember1.getId()).isEqualTo(2);
        Assertions.assertThat(saveMember2.getId()).isEqualTo(3);
        Assertions.assertThat(saveMember1.getId()).isNotEqualTo(saveMember2.getId());

    }

}