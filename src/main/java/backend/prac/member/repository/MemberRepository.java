package backend.prac.member.repository;

import backend.prac.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

//    private Map<Long, Member> store = new HashMap<>();
//    private Long sequence = 0L;
//
//    public Member save(Member member) {
//        member.setId(++sequence);
//        store.put(member.getId(), member);
//        return member;
//    }

    void addMember(Member member);

}
