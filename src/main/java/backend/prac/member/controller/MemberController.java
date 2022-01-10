package backend.prac.member.controller;

import backend.prac.member.domain.Member;
import backend.prac.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

//    @PostMapping("/find")
//    public String editMemberInfo(@PathVariable Long id, Member member) {
//        Optional<Member> m = memberService.findMember(id);
//
//        m.ifPresent(selectMember -> {
//            selectMember.setId(member.getId());
//            selectMember.setLoginId(member.getLoginId());
//            selectMember.setUsername(member.getUsername());
//            selectMember.setNickname(member.getNickname());
//            selectMember.setPassword(member.getPassword());
//
//        });
//        return "member/findMember";
//    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> memberList = memberService.memberList();
        model.addAttribute("members", memberList);
        return "member/memberList";
    }

//    @GetMapping("/detail/{id}")
//    public String detail(@PathVariable("id") Long id, Model model) {
//        Optional<Member> member = memberService.findMember(id);
//        model.addAttribute("post", member);
//        return "memberList";
//    }

    @PostMapping("/post/detail/{id}")
    public String update(Member member) {
        memberService.addMember(member);
        return "redirect:/";
    }
}
