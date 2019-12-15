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

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;


        helper = new MimeMessageHelper(message, "utf-8");
        helper.setTo(to);
       helper.setSubject(subject);
       helper.setText(body, true);


        javaMailSender.send(message);
    }

}
