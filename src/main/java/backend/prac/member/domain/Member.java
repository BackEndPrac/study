package backend.prac.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@AllArgsConstructor
@Setter
public class Member {

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
