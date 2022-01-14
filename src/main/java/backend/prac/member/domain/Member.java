package backend.prac.member.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String nickname;

    @OneToOne
    @JoinColumn(name = "LOGIN_ID")
    private Login login;

    @NotEmpty
    private String enrollmentId; // 로그인 id

    @NotEmpty
    private String password; // 비밀번호
}
