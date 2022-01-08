package backend.prac.member.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String nickname;
    private String loginId; // 로그인 id
    private String password; // 비밀번호

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public Member cSetUsername(String username) {
        this.username = username;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public Member cSetNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getLoginId() {
        return loginId;
    }

    public Member cSetLoginId(String loginId) {
        this.loginId = loginId;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Member cSetPassword(String password) {
        this.password = password;
        return this;
    }
}
