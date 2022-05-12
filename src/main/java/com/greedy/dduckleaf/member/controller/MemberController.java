package com.greedy.dduckleaf.member.controller;

import com.google.gson.*;
import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.member.dto.MemberDTO;
import com.greedy.dduckleaf.member.dto.MemberWithdrawDTO;
import com.greedy.dduckleaf.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import static com.greedy.dduckleaf.common.utility.DateFormatting.getDateAndTime;

/**
 * <pre>
 * Class: MemberController
 * Comment : 회원관리
 * History
 * 2022/04/18 (박상범) 처음 작성 / 로그인, 로그 아웃 관련 메소드 추가
 * 2022/04/19 (박상범) 이메일 인증 번호 전송 관련 메소드 구현 시작
 * 2022/04/21 (박상범) 이메일 인증 번호 전송 관련 메소드 구현 완료, 휴대폰 인증 번호 전송 관련 메소드 구현 시작
 * 2022/04/22 (박상범) 휴대폰 인증번호 전송 관련 메소드 구현 완료, 아이디 중복 체크 관련 메소드 구현 완료, 회원 가입 관련 메소드 구현 완료
 * 2022/04/23 (박상범) 아이디 찾기 관련 메소드 구현 완료
 * 2022/04/27 (박상범) 비밀번호 찾기 관련 메소드 구현 완료
 * 2022/05/09 (박상범) 회원 탈퇴 관련 메소드 작성
 * </pre>
 * @version 1.0.9
 * @author 박상범
 */
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final MessageSource messageSource;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberController(MemberService memberService, MessageSource messageSource, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.messageSource = messageSource;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * login: 로그인을 위해 로그인 페이지로 포워드합니다.
     * @author 박상범
     */
    @GetMapping("/login")
    public void login() {}

    /**
     * loginSuccess: 로그인 성공 후 리다이덱트 요청을 합니다.
     * @return mv
     * @author 박상범
     */
    @PostMapping("/loginSuccess")
    public ModelAndView loginSuccess(ModelAndView mv) {

        mv.setViewName("redirect:/");

        return mv;
    }

    /**
     * logout : 로그 아웃 합니다.
     * @author 박상범
     */
    @GetMapping("/logout")
    public void logout() {}

    /**
     * registMember: 회원 가입을 위해 회원 가입 페이지로 포워드합니다.
     * @author 박상범
     */
    @GetMapping("/regist")
    public void registMember() {}

    /**
     * sendEmailVerification: 회원 가입을 위해 이메일로 인증번호를 전송합니다.
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

    /**
     * sendPhoneVerification: 회원 가입을 위해 휴대폰 번호로 인증번호를 전송합니다.
     * @param phone: 휴대폰 인증 번호를 전송할 휴대폰 번호
     * @return gson.toJson(phoneResult)
     * @author 박상범
     */
    @GetMapping(value = "/sendPhoneVerification", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String sendPhoneVerification(String phone){

        String phoneResult = memberService.sendPhoneVerification(phone);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return gson.toJson(phoneResult);
    }

    /**
     * checkDuplicateMemberId: 회원 가입을 위해 아이디 중복 확인을 합니다.
     * @param memberId: 아이디 증복 확인할 아이디
     * @return gson.toJson(checkResult)
     * @author 박상범
     */
    @GetMapping(value = "/checkDuplicateMemberId", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String checkDuplicateMemberId(String memberId){

        String checkResult = memberService.checkDuplicationMemberId(memberId);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return gson.toJson(checkResult);
    }

    /**
     * registMember : 떡잎펀드 서비스를 이용하기 위해 회원 가입을 합니다.
     * @param member: 회원가입할 회원의 정보
     * @return "/member/login"
     * @author 박상범
     */
    @PostMapping("/regist")
    public ModelAndView registMember(ModelAndView mv, @ModelAttribute MemberDTO member, HttpServletRequest request, RedirectAttributes rttr, Locale locale){

        String phone = request.getParameter("phone").replace("-", "");
        String email = request.getParameter("email");

        member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));
        member.setPhone(phone);
        member.setEmail(email);
        member.setMemberRole(2);
        member.setWithdrawalStatus("N");
        member.setMemberJoinDate(getDateAndTime());

        memberService.registMember(member);

        rttr.addFlashAttribute("successMessage", messageSource.getMessage("registMemberSuccess", null, locale));
        mv.setViewName("/member/login");

        return mv;
    }

    /**
     * find : 아이디 찾기 페이지로 포워딩합니다.
     * @return /member/find/id
     * @author 박상범
     */
    @GetMapping("/find")
    public String find() {
        return "/member/find/id";
    }

    /**
     * sendMemberId : 입력한 이메일로 등록된 아이디를 전송합니다.
     * @param email: 아이디를 전송 받을 이메일 주소
     * @return mv
     * @author 박상범
     */
    @GetMapping("/find/id")
    public ModelAndView sendMemberId(ModelAndView mv, String email, RedirectAttributes rttr) {

        String result = memberService.sendEmailMemberId(email);

        if(result == "등록된 아이디가 없습니다.") {
            rttr.addFlashAttribute("message", result);
            mv.setViewName("redirect:/member/find/id");
        }
        if(result != "등록된 아이디가 없습니다.") {
            mv.addObject("memberId", result);
            mv.setViewName("/member/find/success");
        }

        return mv;
    }

    /**
     * findMemberPwd : 비밀번호 찾기 페이지로 포워딩합니다.
     * @return /member/find/pwd
     * @author 박상범
     */
    @GetMapping("/find/pwd")
    public String findMemberPwd() {
        return "/member/find/pwd";
    }

    /**
     * checkMemberIdAndEmail : 비밀번호를 변경하기 위해 아이디와 이메일을 입력하여 회원가입여부를 확인합니다.
     * @param data: 회원가입 여부를 확인할 아이디, 이메일
     * @return gson.toJson(result)
     * @author 박상범
     */
    @PostMapping(value = {"/find/check"}, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String checkMemberIdAndEmail(@RequestBody String data) {

        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(data);
        String memberId = jsonElement.getAsJsonObject().get("memberId").getAsString();
        String email = jsonElement.getAsJsonObject().get("email").getAsString();

        MemberDTO member = new MemberDTO();
        member.setMemberId(memberId);
        member.setEmail(email);

        String result = memberService.findMember(member);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return gson.toJson(result);
    }

    /**
     * modifyPage : 비밀번호를 변경하기 위해 아이디와 이메일을 입력하여 회원가입여부를 확인합니다.
     * @param memberId: 회원가입 여부를 확인할 아이디
     * @param email: 회원가입 여부를 확인하고 인증번호를 전송할 이메일
     * @return mv
     * @author 박상범
     */
    @PostMapping("/find/modify")
    public ModelAndView modifyPage(ModelAndView mv, String memberId, String email) {

        MemberDTO member = new MemberDTO();
        member.setMemberId(memberId);
        member.setEmail(email);

        int memberNo = memberService.findMemberNo(member);

        mv.addObject("memberNo", memberNo);
        mv.setViewName("/member/find/modify");

        return mv;
    }

    /**
     * modifyMemberPwd : 회원의 비밀번호를 변경합니다.
     * @param member: 회원번호와 변경할 비밀번호를담은  MemberDTO 객체
     * @return mv
     * @author 박상범
     */
    @PostMapping("/modify/pwd")
    public ModelAndView modifyMemberPwd(ModelAndView mv, MemberDTO member, RedirectAttributes rttr) {

        member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));

        String result = memberService.modifyMemberPwd(member);

        rttr.addFlashAttribute("successMessage", result);
        mv.setViewName("redirect:/member/login");

        return mv;
    }

    /**
     * removeMember : 회원 탈퇴를 합니다.
     * @param withdrawReason: 탈퇴 사유를 담은 변수입니다.
     * @param user: 로그인된 회원 정보
     * @return mv
     * @author 박상범
     */
    @PostMapping(value={"/remove"}, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String removeMember(@RequestBody String withdrawReason, @AuthenticationPrincipal CustomUser user) {

        MemberWithdrawDTO memberWithdraw = new MemberWithdrawDTO();
        memberWithdraw.setMemberNo(user.getMemberNo());
        memberWithdraw.setWithdrawReason(withdrawReason);
        memberWithdraw.setWithdrawDate(getDateAndTime());

        String result = memberService.removeMember(memberWithdraw);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return gson.toJson(result);
    }
}
