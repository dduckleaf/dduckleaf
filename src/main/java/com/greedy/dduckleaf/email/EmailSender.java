package com.greedy.dduckleaf.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Component
public class EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    public String sendMail(String email) throws MessagingException {

        String key = "123456";

        MimeMessage message = javaMailSender.createMimeMessage();
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setSubject("떡잎펀드에서 전송한 인증번호입니다.");
        message.setText(key);

        javaMailSender.send(message);

        return key;
    }
}