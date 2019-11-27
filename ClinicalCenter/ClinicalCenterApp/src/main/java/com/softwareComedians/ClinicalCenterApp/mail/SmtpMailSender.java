package com.softwareComedians.ClinicalCenterApp.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SmtpMailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;

    public void send (String to, String subject, String body) throws MessagingException {

        SimpleMailMessage mail = new SimpleMailMessage();

       mail.setTo(to);
       mail.setFrom(env.getProperty("spring.mail.username"));
       mail.setSubject(subject);
       mail.setText(body);


        javaMailSender.send(mail);
    }

}
