package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.RequestForConsultDTO;
import com.softwareComedians.ClinicalCenterApp.exception.ApiRequestException;
import com.softwareComedians.ClinicalCenterApp.mail.SmtpMailSender;
import com.softwareComedians.ClinicalCenterApp.model.ConsultTerm;
import com.softwareComedians.ClinicalCenterApp.model.RequestForConsult;
import com.softwareComedians.ClinicalCenterApp.model.User;
import com.softwareComedians.ClinicalCenterApp.repository.RequestForConsultRepository;
import com.softwareComedians.ClinicalCenterApp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RequestForConsultService {
    @Autowired
    private RequestForConsultRepository requestForConsultRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ConsultTermService consultTermService;

    @Autowired
    private ConsultTypeService consultTypeService;

    @Autowired
    private RequestForConsultService requestForConsultService;

    @Autowired
    private SmtpMailSender smtpMailSender;

    public RequestForConsult save(RequestForConsult requestForConsult) {
        return requestForConsultRepository.save(requestForConsult);
    }

    public void remove(Long id){
        requestForConsultRepository.deleteById(id);
    }

    public RequestForConsult findById(Long id) {
        try {
            return requestForConsultRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ApiRequestException("Request forConsult term with id '" + id + "' doesn't exist.");
        }
    }

    public List<RequestForConsult> findAll() { return  requestForConsultRepository.findAll(); }

    public RequestForConsult createReq(RequestForConsultDTO requestForConsultDTO, Long userId) throws MessagingException {

        User u = userService.findById(userId);
        ConsultTerm ct = consultTermService.findById(requestForConsultDTO.getId());

        RequestForConsult rq = new RequestForConsult();
        //rq.setId(requestForConsultDTO.getId());
        rq.setDateAndTime(requestForConsultDTO.getDateAndTime());
        rq.setType(consultTypeService.findOne(requestForConsultDTO.getType().getId()));
        rq.setPatient(u);
        rq.setAccepted(false);
        rq.setConsultTerm(ct);

        rq = requestForConsultService.save(rq);

        //salje mejl adminu klinike
        //TODO: preko pacijenotovog ID-a pronaci u kojoj je klinici i poslati mejl odgovarajucem administratoru te klinike
        smtpMailSender.send("pswtim2@gmail.com","Request for consult",
                " You have a request for consult: type: "+ct.getType().getName()+ "\r\n"+
                        "doctor's name: "+ct.getDoctor().getName()+ " "+ct.getDoctor().getSurname()+ "\r\n"+
                        "patient's name: "+u.getName()+" "+u.getSurname()+"\r\n"+
                        " <a href='http://localhost:8080/api/patient/requestConsultTerm/"+rq.getId()+"'> Confirm </a>");

        return rq;
    }
}
