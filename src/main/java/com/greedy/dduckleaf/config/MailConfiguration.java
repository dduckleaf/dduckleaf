package com.greedy.dduckleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.greedy.dduckleaf")
public class MailConfiguration {

    @Bean
    public static JavaMailSender mailSender() {

        JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
        mailSenderImpl.setHost("smtp.gmail.com");
        mailSenderImpl.setPort(587);
        mailSenderImpl.setUsername("tkdjawlwhs@gmail.com");
        mailSenderImpl.setPassword("a33196417");
        mailSenderImpl.setDefaultEncoding("UTF-8");

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.auth", true);
        javaMailProperties.put("mail.smtp.starttls.enable", true);
        javaMailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        mailSenderImpl.setJavaMailProperties(javaMailProperties);

        return mailSenderImpl;
    }
}
