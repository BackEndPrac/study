package backend.prac.member.service;

import backend.prac.member.domain.Member;
import backend.prac.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;

    @Transactional
    public void addMember(Member member) {
        memberRepository.save(member);
    }

    @Transactional
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Transactional
    public Member update(Long id,Member member){
        Member findMember = memberRepository.getById(id);
        findMember.setNickname(member.getNickname());
        findMember.setLoginId(member.getLoginId());
        findMember.setUsername(member.getUsername());

        System.out.println("findMember = " + findMember);
        return findMember;
    }
    @Transactional
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
