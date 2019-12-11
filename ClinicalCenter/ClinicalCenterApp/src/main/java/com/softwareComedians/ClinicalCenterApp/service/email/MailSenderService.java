package com.softwareComedians.ClinicalCenterApp.service.email;

import com.softwareComedians.ClinicalCenterApp.model.ConfirmationToken;
import com.softwareComedians.ClinicalCenterApp.model.RequestForPatientRegistration;
import com.softwareComedians.ClinicalCenterApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendMailForRegistration(final RequestForPatientRegistration user, final ConfirmationToken token) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(user.getUserData().getEmail());
        message.setFrom("ClinicalCenter");
        message.setSubject("Clinical Center - Account activation");
        /*message.setText("Dear " + user.getUserData().getName() + " " + user.getUserData().getSurname() +
                ", go to this address to activate your account " +
                "http://localhost:8080/account-verification.html?token=" + token.getToken());*/
        if (user.getUserData().getAccepted()) {
            message.setText("Dear " + user.getUserData().getName() + " " + user.getUserData().getSurname() +
                    ", Your account is activated. ");
        } else {
            message.setText("Dear " + user.getUserData().getName() + " " + user.getUserData().getSurname() +
                    ", Your registration is rejected. Reason: ");
        }

        mailSender.send(message);
    }
}
