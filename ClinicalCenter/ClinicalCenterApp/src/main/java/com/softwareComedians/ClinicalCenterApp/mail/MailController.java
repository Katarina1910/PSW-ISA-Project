package com.softwareComedians.ClinicalCenterApp.mail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping( value = "api/mail")
public class
MailController {

    @Autowired
    private SmtpMailSender smtpMailSender;

    //u frontednu ovo pozovi za accept
    @GetMapping (value = "/accept/{mail}/{id}")
    public void accept(@PathVariable String mail, @PathVariable String id) throws MessagingException {
        smtpMailSender.send(mail,"Registration", " Please, confirm registration clicking on the following link http://localhost:8080/api/patient/add/"+id);
    }

    //u front endu ovo pozovi za reject
    @GetMapping (value = "/reject/{mail}/{description}")
    public void reject(@PathVariable String mail, @PathVariable String description) throws MessagingException {
        smtpMailSender.send(mail,"Registration", description);
    }
}
