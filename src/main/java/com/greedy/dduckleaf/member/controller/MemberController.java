package com.greedy.dduckleaf.member.controller;

import com.greedy.dduckleaf.authentication.model.service.AuthenticationService;
import com.greedy.dduckleaf.member.dto.MemberDTO;
import com.greedy.dduckleaf.member.service.MemberService;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final MessageSource messageSource;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final AuthenticationService authenticationService;

    public MemberController(MemberService memberService, MessageSource messageSource, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, AuthenticationService authenticationService) {
        this.memberService = memberService;
        this.messageSource = messageSource;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public void login() {}

    @PostMapping("/login")
    public ModelAndView login(MemberDTO member, ModelAndView mv, RedirectAttributes rttr, Locale locale) {

        mv.setViewName("redirect:/");
        rttr.addFlashAttribute("successMessage", messageSource.getMessage("loginSuccess", null, locale));

        return mv;
    }

    @GetMapping("/logout")
    public void logout() {}

    @GetMapping("/regist")
    public void registMember() {}

    @PostMapping("/regist")
    public String registMember(@ModelAttribute MemberDTO member, HttpServletRequest request, RedirectAttributes rttr, Locale locale){

        String phone = request.getParameter("phone").replace("-", "");
        String email = request.getParameter("email");

        member.setPhone(phone);
        member.setEmail(email);
        member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));

        memberService.registMember(member);

        rttr.addFlashAttribute("successMessage", messageSource.getMessage("registMemberSuccess", null, locale));

        return "redirect:/";
    }

}
