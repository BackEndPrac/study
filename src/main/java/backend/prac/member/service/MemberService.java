package backend.prac.member.service;

import backend.prac.member.domain.Login;
import backend.prac.member.domain.Member;
import backend.prac.member.repository.LoginRepository;
import backend.prac.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;
    private final LoginRepository loginRepository;

    @Transactional
    public Member addMember(Member member) {
       return memberRepository.save(member);
    }

    @Transactional
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Transactional
    public Member update(Long id,Member member){
        Member findMember = memberRepository.getById(id);
        findMember.setNickname(member.getNickname());
        findMember.setEnrollmentId(member.getEnrollmentId());
        findMember.setUsername(member.getUsername());

        System.out.println("findMember = " + findMember);
        return findMember;
    }
    @Transactional
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Transactional
    public Member login(String userId, String password) {

        List<Member> members = memberRepository.findAll();
        for (Member member : members) {
            if(member.getEnrollmentId().equals(userId)) {
                if(member.getPassword().equals(password)){

                    return member;
                }
            }
        }
        return null;
    }

    @Transactional
    public Login loginSave(Member member, Login login) {
        member.setLogin(login);
        return loginRepository.save(login);
    }

   @Transactional
    public void logout(Long id) {
        loginRepository.deleteById(id);
    }
}
