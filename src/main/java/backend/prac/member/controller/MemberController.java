package backend.prac.member.controller;

import backend.prac.member.domain.Login;
import backend.prac.member.domain.Member;
import backend.prac.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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


    @GetMapping("/member/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        Member member = memberService.findMember(id).get();

        model.addAttribute("member", member);
        return "member/detail";
    }

    @GetMapping("/member/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Member member = memberService.findMember(id).get();
        System.out.println("member = " + member);

        model.addAttribute("member", member);
        return "member/detail";
    }

    @PostMapping("/member/edit/{id}")
    public String update(@PathVariable Long id, Member member) {

         memberService.update(id, member);


        return "redirect:/";
    }

    @PostMapping("/member/{id}")
    public String delete(@PathVariable("id") Long id) {
        memberService.deleteMember(id);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm(@ModelAttribute Login login) {
        return "login/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute Login login, BindingResult bindingResult, HttpServletRequest request) {
        if(bindingResult.hasErrors()) {
            return "login/login";
        }
        Member member = memberService.login(login.getUserId(), login.getPassword());
        if(member == null) {
            return "login/login";
        }
        HttpSession session = request.getSession();
        System.out.println("session = " + session);
        session.setAttribute("memberId",member);
        return "redirect:/";
    }



}
