package com.softwareComedians.ClinicalCenterApp.mail;


import com.softwareComedians.ClinicalCenterApp.model.RequestForPatientRegistration;
import com.softwareComedians.ClinicalCenterApp.model.User;
import com.softwareComedians.ClinicalCenterApp.service.RequestForPatientRegistrationService;
import com.softwareComedians.ClinicalCenterApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping( value = "api/mail")
public class MailController {

    @Autowired
    private SmtpMailSender smtpMailSender;
    @Autowired
    private UserService userService;
    @Autowired
    private RequestForPatientRegistrationService rq;

    //u frontednu ovo pozovi za accept
    @PutMapping(value = "/accept/{mail}/{id}")
    public void accept(@PathVariable String mail, @PathVariable String id) throws MessagingException {
        smtpMailSender.send(mail,"Registration", " Please, confirm registration clicking on the following link <a href='http://localhost:8080/api/patient/add/"+id+"'> Activate</a>");
    }

    //u front endu ovo pozovi za reject
    @GetMapping (value = "/reject/{mail}/{description}/{id}")
    public void reject(@PathVariable String mail, @PathVariable String description, @PathVariable String id) throws MessagingException {
        long num = Long.parseLong(id);
        smtpMailSender.send(mail,"Registration", description);
        User u = userService.findByEmail(mail);
        userService.remove(u);
        RequestForPatientRegistration r = rq.findOne(num);
        rq.remove(r.getId());

    }
}
