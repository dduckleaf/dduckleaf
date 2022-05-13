package com.greedy.dduckleaf.member.service;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.member.dto.MemberDTO;
import com.greedy.dduckleaf.member.dto.MemberWithdrawDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static com.greedy.dduckleaf.common.utility.DateFormatting.getDateAndTime;

@SpringBootTest
@ContextConfiguration(classes = {
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        JPAConfiguration.class,
        BeanConfiguration.class,
        DduckleafApplication.class
})
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void initTest() {
        assertNotNull(memberService);
    }

    @Test
    @DisplayName("이메일 인증번호 생성해서 중복되는 이메일이면 이미 사용중인 이메일 입니다. 출력")
    public void emailTest() throws MessagingException {

        //given
        String email = "h99www@gmail.com";

        //when
        String result = memberService.sendEmailVerification(email);

        //then
        System.out.println(result);
        assertEquals(result, "이미 사용중인 이메일 입니다.");
    }

    @Test
    @DisplayName("이메일 인증번호 생성해서 중복되는 이메일이 아니면 인증번호 전송")
    public void emailSendTest() throws MessagingException {

        //given
        String email = "sangbum0497@gmail.com";

        //when
        String result = memberService.sendEmailVerification(email);

        //then
        System.out.println(result);
        assertNotEquals(result, "이미 사용중인 이메일 입니다.");
    }

    @Test
    @DisplayName("중복되는 휴대본 번호면 이미 사용중인 휴대전화 번호입니다. 출력 ")
    public void phoneSendTest() {

        //given
        String phone = "01065524838";

        //when
        String result = memberService.sendPhoneVerification(phone);

        //then
        assertEquals(result,"이미 사용중인 휴대전화 번호입니다.");
    }

    @Test
    @DisplayName("중복되는 휴대폰 번호가 아니면 인증번호 리턴")
    public void phoneVerificationTest() {

        //given
        String phone = "01038109897";

        //when
        String result = memberService.sendPhoneVerification(phone);

        //then
        assertNotEquals(result, "인증번호 전송 실패");
        assertNotEquals(result, "이미 사용중인 휴대전화 번호입니다.");
        assertNotEquals(result, "휴대폰 번호가 유효하지 않습니다.");
        assertNotEquals(result, "휴대폰 번호를 입력해주세요.");
    }

    @Test
    @DisplayName("휴대폰 번호를 입력 안했을 경우")
    public void phoneNullTest() {

        //given
        String phone = "";

        //when
        String result = memberService.sendPhoneVerification(phone);

        //then
        assertEquals(result, "휴대폰 번호를 입력해주세요.");
    }

    @Test
    @DisplayName("휴대폰 번호가 형식에 맞지 않은 경우")
    public void phoneOutOfFormatTest() {

        //given
        String phone = "123";

        //when
        String result = memberService.sendPhoneVerification(phone);

        //then
        assertEquals(result, "휴대폰 번호가 유효하지 않습니다.");
    }

    @Test
    @DisplayName("휴대폰 번호 형식은 맞지만 존재하지않거나 010으로 시작하지 않을 경우")
    public void phoneNotExistTest() {

        //given
        String phone = "qweqwerqwer";

        //when
        String result = memberService.sendPhoneVerification(phone);

        //then
        assertEquals(result, "인증번호 전송 실패");
    }

    @Test
    @DisplayName("아이디 중복 체크 아이디를 입력안한경우")
    public void notInputMemberIdTest() {

        //given
        String memberId = "";

        //when
        String result = memberService.checkDuplicationMemberId(memberId);

        //then
        assertEquals(result, "아이디를 입력해주세요.");
    }

    @Test
    @DisplayName("아이디 중복 체크 중복된 아이디인 경우")
    public void duplicatedMemberId() {

        //given
        String memberId = "admin";

        //when
        String result = memberService.checkDuplicationMemberId(memberId);

        //then
        assertEquals(result, "중복된 아이디입니다.");
    }

    @Test
    @DisplayName("아이디 중복 체크 사용가능한 아이디인 경우")
    public void usableMemberId() {

        //given
        String memberId = "흥칫뿡야";

        //when
        String result = memberService.checkDuplicationMemberId(memberId);

        //then
        assertEquals(result, "사용가능한 아이디입니다.");
    }

    @Test
    @DisplayName("등록된 이메일이 없을 경우")
    public void notExistEmailTest() {

        //given
        String email = "sangbum0313@nate.com";

        //when
        String result = memberService.sendEmailMemberId(email);

        //then
        assertEquals(result, "등록된 아이디가 없습니다.");
    }

    @Test
    @DisplayName("등록된 이메일이 있는 경우 이메일로 아이디 전송")
    public void existEmailTest() {

        //given
        String email = "tkdjawlwhs@naver.com";

        //when
        String result = memberService.sendEmailMemberId(email);

        //then
        assertEquals(result, "qwer");
    }

    @Test
    @DisplayName("입력한 아이디와 이메일로 회원가입 여부 확인 성공")
    public void findMemberByMemberIdAndEmailSuccessTest() {

        //given
        MemberDTO member = new MemberDTO();
        member.setMemberId("qwer");
        member.setEmail("tkdjawlwhs@naver.com");

        //when
        String result = memberService.findMember(member);

        //then
        System.out.println(result);
        assertNotEquals(result,"아이디와 이메일이 일치하는 회원의 정보가 없습니다.");
    }


    @Test
    @DisplayName("입력한 아이디와 이메일로 회원가입 여부 확인 실패")
    public void findMemberByMemberIdAndEmailFailedTest() {

        //given
        MemberDTO member = new MemberDTO();
        member.setMemberId("qwert");
        member.setEmail("tkdjawlwhs@naver.com");

        //when
        String result = memberService.findMember(member);

        //then
        assertEquals(result, "아이디와 이메일이 일치하는 회원의 정보가 없습니다.");
    }

    @Test
    @DisplayName("입력한 아이디와 이메일로 회원번호 리턴")
    public void findMemberNo() {

        //given
        MemberDTO member = new MemberDTO();
        member.setMemberId("qwer");
        member.setEmail("tkdjawlwhs@naver.com");

        //when
        int memberId = memberService.findMemberNo(member);

        //then
        System.out.println(memberId);
        assertNotNull(memberId);
    }

    @Test
    @DisplayName("회원번호로 비밀번호 변경 태스트")
    @Transactional
    public void modifyMemberPwdTest() {

        //given
        MemberDTO member = new MemberDTO();
        member.setMemberNo(67);
        member.setMemberPwd(passwordEncoder.encode("@@@@@@@@@@@@@@@@@@@@"));

        //when
        String result = memberService.modifyMemberPwd(member);

        //then
        assertEquals(result, "비밀번호가 변경되었습니다. 로그인페이지로 이동힙니다.");
    }

    @Test
    @DisplayName("회원 탈퇴 테스트")
    @Transactional
    public void removeMemberTest() {

        //given
        MemberWithdrawDTO memberWithdraw = new MemberWithdrawDTO();
        memberWithdraw.setWithdrawReason("서비스 불만족");
        memberWithdraw.setWithdrawDate("20220508");
        memberWithdraw.setMemberNo(67);

        //when
        String result = memberService.removeMember(memberWithdraw);

        //then
        System.out.println(result);
        assertEquals(result, "로그인페이지로 돌아갑니다.");
    }

    @Test
    @DisplayName("회원 가입 테스트")
    public void registMemberTest() {

        //given
        MemberDTO member = new MemberDTO();
        member.setMemberName("박상범");
        member.setMemberId("qkrtkdqja");
        member.setMemberPwd("123123123");
        member.setEmail("sangbum0497@gmail.com");
        member.setPhone("01011111111");
        member.setMemberJoinDate(getDateAndTime());

        //when

        //then
        assertDoesNotThrow(() -> memberService.registMember(member));
    }
}
