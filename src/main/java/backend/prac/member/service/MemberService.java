package backend.prac.member.service;

import backend.prac.member.domain.Member;
import backend.prac.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public void addMember(Member member) {
        memberRepository.save(member);
    }

    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    public List<Member> memberList() {
        return memberRepository.findAll();
    }
}
