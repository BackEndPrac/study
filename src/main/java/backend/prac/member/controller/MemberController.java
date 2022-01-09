package backend.prac.member.controller;

import backend.prac.member.domain.Member;
import backend.prac.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/add")
    public String addMember(@ModelAttribute Member member) {
        return "member/addMember";
    }

    @PostMapping("/add")
    public String enrollmentMember(@Validated @ModelAttribute Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member/addMember";
        }
        memberService.addMember(member);
        log.info(member.toString());
        return "redirect:/";
    }

    @PutMapping("/find")
    public Optional<Member> editMemberInfo(@RequestParam Long id, @RequestBody Member member) {
        Optional<Member> m = memberService.findMember(id);

        m.ifPresent(selectMember -> {
            selectMember.setId(member.getId());
            selectMember.setLoginId(member.getLoginId());
            selectMember.setUsername(member.getUsername());
            selectMember.setNickname(member.getNickname());
            selectMember.setPassword(member.getPassword());

            memberService.addMember(selectMember);
        });
        log.info(m.toString());

        return m;
    }

}
