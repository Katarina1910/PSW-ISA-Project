package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.RequestForConsultDTO;
import com.softwareComedians.ClinicalCenterApp.exception.ApiRequestException;
import com.softwareComedians.ClinicalCenterApp.mail.SmtpMailSender;
import com.softwareComedians.ClinicalCenterApp.model.*;
import com.softwareComedians.ClinicalCenterApp.repository.RequestForConsultRepository;
import com.softwareComedians.ClinicalCenterApp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.ArrayList;
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
    private SmtpMailSender smtpMailSender;

    @Autowired
    private ClinicAdminService clinicAdminService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private PatientService patientService;


    @Autowired
    private  RoomTermsServie roomTermsServie;

    @Autowired
    private  DoctorTermsService doctorTermsService;

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

        rq = this.save(rq);

        //salje mejl adminu klinike
        //TODO: preko pacijenotovog ID-a pronaci u kojoj je klinici i poslati mejl odgovarajucem administratoru te klinike

        String adminEmail="";
        if(ct.getClinic()!=null) {
        Long clinicId = ct.getClinic().getId();

            List<ClinicAdministrator> admins = clinicAdminService.findAll();
            for (ClinicAdministrator ca : admins) {
                if (ca.getClinic().getId() == clinicId) {
                    adminEmail = ca.getEmail();
                }
            }

            if (adminEmail == "") {
                adminEmail = clinicAdminService.findById(1L).getEmail();
            }
        smtpMailSender.send(adminEmail,"Request for consult",
                " You have a request for consult: type: "+ct.getType().getName()+ "\r\n"+
                        "doctor's name: "+ct.getDoctor().getName()+ " "+ct.getDoctor().getSurname()+ "\r\n"+
                        "patient's name: "+u.getName()+" "+u.getSurname()+"\r\n"+
                        "Date: "+rq.getConsultTerm().getDate());

            smtpMailSender.send(adminEmail, "Request for consult",
                    " You have a request for consult: type: " + ct.getType().getName() + "\r\n" +
                            "doctor's name: " + ct.getDoctor().getName() + " " + ct.getDoctor().getSurname() + "\r\n" +
                            "patient's name: " + u.getName() + " " + u.getSurname() + "\r\n" +
                            " <a href='http://localhost:8080/api/patient/requestConsultTerm/" + rq.getId() + "'> Confirm </a>");
        }
        return rq;
    }

    public List<RequestForConsultDTO> getAll() {

        List<RequestForConsult> requestForConsults = this.findAll();
        List<RequestForConsultDTO> requestForConsultDTOS= new ArrayList<>();
        for (RequestForConsult d : requestForConsults) {
            if(d.isAccepted()==false){
                requestForConsultDTOS.add(new RequestForConsultDTO(d));
            }

        }
        return requestForConsultDTOS;
    }

    public RequestForConsult createRequest( RequestForConsultDTO requestForConsultDTO) {

        RequestForConsult rq = new RequestForConsult();
        rq.setId(requestForConsultDTO.getId());
        rq.setType(consultTypeService.findOne(requestForConsultDTO.getType().getId()));
        rq = this.save(rq);
        return rq;
    }

    public RequestForConsult createRequestDoctor( RequestForConsultDTO requestForConsultDTO) throws MessagingException {
        boolean cT = true;
        boolean dT = true;

        RequestForConsult rq = new RequestForConsult();
        rq.setAccepted(true);
        rq.setId(requestForConsultDTO.getId());
        rq.setDateAndTime(requestForConsultDTO.getDateAndTime());
        rq.setType(consultTypeService.findOne(requestForConsultDTO.getType().getId()));
        rq.setPatient(userService.findById(requestForConsultDTO.getPatient().getId()));

        for(RoomTerms rr : roomTermsServie.findAll()){
            if (rr.getDate().equals(rq.getDateAndTime())){
                cT = false;
            }
        }

        for(DoctorTerms dt : doctorTermsService.findAll()){
            if (dt.getDate().equals(rq.getDateAndTime())){
                dT = false;
            }
        }
        if(cT){
            System.out.println("ctt");
            for (Room r: roomService.findAll()){
                System.out.println(r.getName());
                RoomTerms roomTerms = new RoomTerms();
                roomTerms.setDate(requestForConsultDTO.getDateAndTime());
                roomTerms.setRoom(r);
                roomTermsServie.save(roomTerms);
            }
        }

        if(dT){
            System.out.println("dtt");
            for (Doctor d: doctorService.findAll()){
                System.out.println(d.getName());
                DoctorTerms dTerms = new DoctorTerms();
                dTerms.setDate(requestForConsultDTO.getDateAndTime());
                dTerms.setDoctor(d);
                doctorTermsService.save(dTerms);
            }
        }

        String adminEmail="";
        Patient patient = patientService.findById(rq.getPatient().getId());
        Long clinicId = patient.getClinic().getId();
        List<ClinicAdministrator> admins = clinicAdminService.findAll();
        for(ClinicAdministrator ca : admins) {
            if(ca.getClinic().getId() == clinicId) {
                adminEmail = ca.getEmail();
            }
        }

        if(adminEmail=="") {
            adminEmail = clinicAdminService.findById(1L).getEmail();
        }

        smtpMailSender.send(adminEmail,"Request for consult",
                " You have a request for consult: type: "+rq.getType().getName()+ "\r\n"+
                        "patient's name: "+patient.getName()+" "+patient.getSurname());

        rq = this.save(rq);

        return rq;
    }



}
