package backend.prac;

import backend.prac.member.domain.Login;
import backend.prac.member.domain.Member;
import backend.prac.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    private final MemberService memberService;


    @GetMapping
    public String home(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session == null) {
          return  "index";
        }

        Member memberId =(Member) session.getAttribute("memberId");
        if(memberId == null) {
            return "index";
        }
        model.addAttribute("member",memberId);


        return "loginHome";
    }


}
