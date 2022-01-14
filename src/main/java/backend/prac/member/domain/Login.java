package backend.prac.member.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;

@Getter
@Setter
@Entity
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOGIN_ID")
    private Long id;
    private String userId;
    private String password;

    @OneToOne(mappedBy = "login")

    private Member member;
}
