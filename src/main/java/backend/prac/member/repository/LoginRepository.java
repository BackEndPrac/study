package backend.prac.member.repository;

import backend.prac.member.domain.Login;
import backend.prac.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {


}
