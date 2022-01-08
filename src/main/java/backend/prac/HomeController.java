package backend.prac;

import backend.prac.member.domain.Member;
import backend.prac.member.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    private final MemberService memberService;

    @GetMapping
    public String home() {
        return "index";
    }

//    @PostConstruct
    public void init() {
//        Member save = memberService.save(new Member(null, "첫손님", "일등", "qwer123", "test1!"));
//        log.info("save={}", save.toString());

    }
}
