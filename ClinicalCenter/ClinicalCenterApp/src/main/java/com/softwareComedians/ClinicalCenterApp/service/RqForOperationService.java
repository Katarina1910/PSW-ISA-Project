package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.RequestForOperationDTO;
import com.softwareComedians.ClinicalCenterApp.mail.SmtpMailSender;
import com.softwareComedians.ClinicalCenterApp.model.*;
import com.softwareComedians.ClinicalCenterApp.repository.RqForOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RqForOperationService {
    @Autowired
    private RqForOperationRepository rqForOperationRepository;

    @Autowired
    private  PatientService patientService;

    @Autowired
    private SmtpMailSender smtpMailSender;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomTermsServie roomTermsServie;

    @Autowired
    private  DoctorTermsService doctorTermsService;

    @Autowired
    private ClinicAdminService clinicAdminService;

    @Autowired
    private OperationService operationService;

    @Autowired
    private  MedicalRecordService medicalRecordService;

    @Autowired
    private UserService userService;



    public RequstForOperation save(RequstForOperation requestForOperation) {
        return rqForOperationRepository.save(requestForOperation);
    }

    public void remove(Long id){
        rqForOperationRepository.deleteById(id);
    }

    public RequstForOperation findOne(Long id){
        return rqForOperationRepository.findById(id).orElseGet(null);
    }

    public List<RequstForOperation> findAll() { return  rqForOperationRepository.findAll(); }

    public List<RequestForOperationDTO> getAllRequest() {

        List<RequstForOperation> requestForOP = this.findAll();
        List<RequestForOperationDTO> requestForOPDTOS= new ArrayList<>();
        for (RequstForOperation d : requestForOP) {
            requestForOPDTOS.add(new RequestForOperationDTO(d));
        }
        return requestForOPDTOS;
    }

    public RequstForOperation createRequest( RequestForOperationDTO requestForOperationDTO) {

        RequstForOperation rq = new RequstForOperation();
        rq.setId(requestForOperationDTO.getId());

        rq = this.save(rq);
        return rq;
    }

    public RequstForOperation createRequestDoctor(RequestForOperationDTO requestForOperationDTO) throws MessagingException {

        boolean cT = true;
        boolean dT = true;

        RequstForOperation rq = new RequstForOperation();
        rq.setId(requestForOperationDTO.getId());
        System.out.println(requestForOperationDTO.getPatient().getName());
        rq.setDateAndTime(requestForOperationDTO.getDateAndTime());
        User patient = userService.findById(requestForOperationDTO.getPatient().getId());
        System.out.println(patient.getName());
        rq.setPatient(patient);

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
            for (Room r: roomService.findAll()){
                System.out.println(r.getName());
                RoomTerms roomTerms = new RoomTerms();
                roomTerms.setDate(requestForOperationDTO.getDateAndTime());
                roomTerms.setRoom(r);
                roomTermsServie.save(roomTerms);
            }
        }

        if(dT){
            for (Doctor d: doctorService.findAll()){
                System.out.println(d.getName());
                DoctorTerms dTerms = new DoctorTerms();
                dTerms.setDate(requestForOperationDTO.getDateAndTime());
                dTerms.setDoctor(d);
                doctorTermsService.save(dTerms);
            }
        }

        rq = this.save(rq);

        String adminEmail="";
        Patient p = patientService.findById(patient.getId());
        Long clinicId = p.getClinic().getId();
        List<ClinicAdministrator> admins = clinicAdminService.findAll();
        for(ClinicAdministrator ca : admins) {
            if(ca.getClinic().getId() == clinicId) {
                adminEmail = ca.getEmail();
            }
        }

        if(adminEmail=="") {
            adminEmail = clinicAdminService.findById(1L).getEmail();
        }

        smtpMailSender.send(adminEmail,"Request for operation",
                " You have a request for operation "+
                        "patient's name: "+patient.getName()+" "+patient.getSurname());

        return rq;
    }

    public Operation reserveOperation(String date,String term, String room,Long doctor,Long id) throws MessagingException {

        Operation ct = new Operation();
        RequstForOperation rq = this.findOne(id);
        List<RoomTerms> rts= roomTermsServie.findByDate(date);
        List<DoctorTerms> dts = doctorTermsService.findByDate(date);
        DoctorTerms dt = null;
        RoomTerms r = null;
        for (RoomTerms rr : rts){
            if(rr.getRoom().getName().equals(room)){
                r=rr;
            }
        }
        for(DoctorTerms d : dts){
            if(d.getDoctor().getId() == doctor){
                dt = d;
            }
        }

        if(term.equals("07:00-09:00")){
            r.setTerm1(false);
            dt.setTerm1(false);
        }else if(term.equals("09:00-11:00")){
            r.setTerm2(false);
            dt.setTerm2(false);
        }else if(term.equals("11:00-13:00")){
            r.setTerm3(false);
            dt.setTerm3(false);
        }
        else if(term.equals("13:00-15:00")){
            r.setTerm4(false);
            dt.setTerm4(false);
        }else if(term.equals("15:00-17:00")){
            r.setTerm5(false);
            dt.setTerm5(false);
        }else if(term.equals("17:00-19:00")){
            r.setTerm6(false);
            dt.setTerm6(false);
        }
        roomTermsServie.save(r);
        doctorTermsService.save(dt);
        ct.setRoom(roomService.findByName(room));
        ct.setRequstForOperation(rq);
        Patient patient = patientService.findById(rq.getPatient().getId());
        MedicalRecord mr = medicalRecordService.getByUserId2(patient.getId());
        ct.setMedicalRecord(mr);
        ct = operationService.saveOperation(ct);

        smtpMailSender.send(patient.getEmail(),"Operation",
                " You have a new operation : "+dt.getDate());

        smtpMailSender.send(dt.getDoctor().getEmail()," Operation",
                " You have a new Operation : "+dt.getDate());

        this.remove(rq.getId());

        return ct;
    }

}

