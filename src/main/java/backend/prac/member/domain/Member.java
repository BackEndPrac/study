package backend.prac.member.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String nickname;

    @NotEmpty
    private String loginId; // 로그인 id

    @NotEmpty
    private String password; // 비밀번호
}
