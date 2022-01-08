package backend.prac.member.service;

import backend.prac.member.domain.Member;
import backend.prac.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void addMember(Member member) {
        memberRepository.addMember(member);
    }

}
