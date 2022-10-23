package com.ll.exam.books_YonghoSong.app.mail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Random;

@PropertySource("classpath:application.yml")
@Slf4j
@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    //https://velog.io/@kyungwoon/%EC%9D%B4%EB%A9%94%EC%9D%BC%EB%A1%9C-%EC%9D%B8%EC%A6%9D-%EC%BD%94%EB%93%9C-%EB%B3%B4%EB%82%B4%EA%B8%B0SpringBoot-SMTP


    @Value("${spring.mail.username}")
    private String id;

    public MimeMessage createMessage(String to)throws MessagingException, UnsupportedEncodingException {
        log.info("보내는 대상 : "+ to);
        MimeMessage  message = javaMailSender.createMimeMessage();

        message.addRecipients(MimeMessage.RecipientType.TO, to); // to 보내는 대상
        message.setSubject("멋북 회원가입을 환영합니다 - 개발자 송용호"); //메일 제목

        // 메일 내용 메일의 subtype 을 html 로 지정하여 html 문법 사용 가능
        String msg="";
        msg += "<h1 style=\"font-size: 30px; padding-right: 30px; padding-left: 30px;\">환영 이메일</h1>";
        msg += "<p style=\"font-size: 17px; padding-right: 30px; padding-left: 30px;\">멋북 회원가입을 환영합니다.</p>";


        message.setText(msg, "utf-8", "html"); //내용, charset 타입, subtype
        message.setFrom(new
                InternetAddress(id,"MutBook_Admin")); //보내는 사람의 메일 주소, 보내는 사람 이름

        return message;
    }


    public int sendSimpleMessage(String to)throws Exception {
        MimeMessage message = createMessage(to);
        try{
            javaMailSender.send(message); // 메일 발송
        }catch(MailException es){
            es.printStackTrace();
            throw new IllegalArgumentException();
        }
        return 0;
    }
}