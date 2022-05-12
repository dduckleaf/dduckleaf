package com.greedy.dduckleaf.email;

import com.greedy.dduckleaf.member.entity.Member;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * <pre>
 * Class : EmailSender
 * Comment : 이메일 전송
 * History
 * 2022/04/19 (박상범) 처음 작성 / 인증 번호 전송 관련 메소드 작성
 * 2022/04/23 (박상범) 아이디 전송 관련 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박상범
 */
@Component
public class EmailSender {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String sendMailVerification(String email){

        String key = (int) (Math.random() * 899999) + 100000 + "";

        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("떡잎펀드에서 전송한 인증번호입니다.");
            message.setText(key);
            javaMailSender.send(message);
        } catch (MessagingException e){
            e.printStackTrace();
        }

        return key;
    }

    public String sendMailMemberId(Member member) {

        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(member.getEmail()));
            message.setSubject("떡잎펀드에서 전송한 인증번호입니다.");
            message.setText(member.getMemberId());
            javaMailSender.send(message);
        } catch(MessagingException e) {
            e.printStackTrace();
            return "false";
        }

        return member.getMemberId();
    }
}
