package com.greedy.dduckleaf.member.controller;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greedy.dduckleaf.authentication.model.service.AuthenticationService;
import com.greedy.dduckleaf.member.dto.MemberDTO;
import com.greedy.dduckleaf.member.service.MemberService;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
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

    /**
     * login: 로그인을 위해 로그인 페이지로 포워딩 한다.
     * @author 박상범
     */
    @GetMapping("/login")
    public void login() {}

    /**
     * login: 떡잎 펀드 서비스를 이용하기 위해 로그인 합니다.
     * @param member: 로그인을 시도할 로그인 정보
     * @param mv:
     * @param rttr:
     * @param locale:
     * @return
     * @author 박상범
     */
    @PostMapping("/login")
    public ModelAndView login(MemberDTO member, ModelAndView mv, RedirectAttributes rttr, Locale locale) {

        mv.setViewName("redirect:/");
        rttr.addFlashAttribute("successMessage", messageSource.getMessage("loginSuccess", null, locale));

        return mv;
    }

    /**
     * logout : 로그 아웃 합니다.
     * @author 박상범
     */
    @GetMapping("/logout")
    public void logout() {}

    /**
     * registMember: 회원 가입을 위해 회원 가입 페이지로 포워딩합니다.
     * @author 박상범
     */
    @GetMapping("/regist")
    public void registMember() {}

    /**
     * sendEmailVerification: 회원 가입을 위해 이메일로 인증번호를 전송한다.
     * @param email: 이메일 인증 번호를 전송할 이메일 주소
     * @return gson.toJson(emailResult)
     * @author 박상범
     */
    @GetMapping(value = "/sendEmailVerification", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String sendEmailVerification(String email) throws MessagingException {

        String emailResult = memberService.sendEmailVerification(email);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return gson.toJson(emailResult);
    }

}
