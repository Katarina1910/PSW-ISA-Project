package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.RequestForAbsenceDTO;
import com.softwareComedians.ClinicalCenterApp.model.Clinic;
import com.softwareComedians.ClinicalCenterApp.model.Personnel;
import com.softwareComedians.ClinicalCenterApp.model.RequestForAbsence;
import com.softwareComedians.ClinicalCenterApp.repository.ConfirmationTokenRepository;
import com.softwareComedians.ClinicalCenterApp.repository.RqAbsenceRepository;
import com.softwareComedians.ClinicalCenterApp.repository.UserRepository;
import com.softwareComedians.ClinicalCenterApp.service.email.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestForAbsenceService {

    @Autowired
    private RqAbsenceRepository rqAbsenceRepository;

    private UserRepository userRepository;

    @Autowired
    public RequestForAbsenceService(RqAbsenceRepository rqAbsenceRepository) {
        this.rqAbsenceRepository = rqAbsenceRepository;
    }

    public RequestForAbsence save(RequestForAbsence rq) {
        return rqAbsenceRepository.save(rq);
    }

    public List<RequestForAbsence> findAll() {
        return  rqAbsenceRepository.findAll();
    }

    public void remove(Long id){
        rqAbsenceRepository.deleteById(id);
    }

    public RequestForAbsence findOne(Long id){
        return rqAbsenceRepository.findById(id).orElseGet(null);
    }

    public List<RequestForAbsence> findAllById(Long id) {
        return  rqAbsenceRepository.findAllByUserId(id);
    }


    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    private UserService userService;

    @Autowired
    private ClinicsService clinicsService;

    @Autowired
    private ClinicAdminService clinicAdminService;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    public RequestForAbsence createRqForAbsence( RequestForAbsenceDTO rqDTO) {

        RequestForAbsence rq = new RequestForAbsence();

        Personnel applicant = (Personnel) userService.findById(rqDTO.getApplicant().getId());
        rq.setId(rqDTO.getId());
        rq.setAccepted(rqDTO.isAccepted());
        rq.setResaonOfRejection(rqDTO.getResaonOfRejection());
        rq.setFroom(rqDTO.getFrom());
        rq.setToo(rqDTO.getTo());
        rq.setApplicant(applicant);
        Clinic c = clinicsService.findById(applicant.getClinic().getId());
        rq.setClinicAdministrator(clinicAdminService.findById(c.getClinicAdministrator().getId()));
        rq = this.save(rq);
        return rq;
    }

    public List<RequestForAbsenceDTO> getAll() {

        List<RequestForAbsence> rqs = this.findAll();
        List<RequestForAbsenceDTO> rqsDTO = new ArrayList<>();
        for (RequestForAbsence rq : rqs) {
            rqsDTO.add(new RequestForAbsenceDTO(rq));
        }
        return rqsDTO;
    }

    public List<RequestForAbsenceDTO> getAllDoctor( Long id) {

        List<RequestForAbsence> rqs = this.findAllById(id);
        List<RequestForAbsenceDTO> rqsDTO = new ArrayList<>();
        for (RequestForAbsence rq : rqs) {
            if(rq.isAccepted() == true) {
                rqsDTO.add(new RequestForAbsenceDTO(rq));
            }
        }
        return rqsDTO;
    }

}
