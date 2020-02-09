package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.RequestForPatientRegistrationDTO;
import com.softwareComedians.ClinicalCenterApp.model.RequestForPatientRegistration;
import com.softwareComedians.ClinicalCenterApp.repository.RequestForPatientRegistrationRepository;
import com.softwareComedians.ClinicalCenterApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestForPatientRegistrationService {

    private RequestForPatientRegistrationRepository requestForPatientRegistrationRepository;

    private UserRepository userRepository;

    @Autowired
    public RequestForPatientRegistrationService(RequestForPatientRegistrationRepository requestForPatientRegistrationRepository) {
        this.requestForPatientRegistrationRepository = requestForPatientRegistrationRepository;
    }

    public RequestForPatientRegistration save(RequestForPatientRegistration requestForPatientRegistration) {
        return requestForPatientRegistrationRepository.save(requestForPatientRegistration);
    }

    public List<RequestForPatientRegistration> findAll() {
        return  requestForPatientRegistrationRepository.findAll();
    }

    public void remove(Long id){
        requestForPatientRegistrationRepository.deleteById(id);
    }

    public RequestForPatientRegistration findOne(Long id){
        return requestForPatientRegistrationRepository.findById(id).orElseGet(null);
    }

    public void setAccepted(RequestForPatientRegistration regForPatientReq) {
        requestForPatientRegistrationRepository.save(regForPatientReq);

    }

    public RequestForPatientRegistration createRqForPatientReg( RequestForPatientRegistrationDTO rqDTO) {

        RequestForPatientRegistration rq = new RequestForPatientRegistration();
        rq.setId(rqDTO.getId());
        rq.setAccepted(rqDTO.isAccepted());
        rq.setReasonOfRejection(rqDTO.getReasonOfRejection());
        rq.setUserData(rq.getUserData());
        rq = this.save(rq);
        return rq;
    }

    public List<RequestForPatientRegistrationDTO> getAll() {

        List<RequestForPatientRegistration> rqs = this.findAll();
        List<RequestForPatientRegistrationDTO> rqsDTO = new ArrayList<>();
        for (RequestForPatientRegistration rq : rqs) {
            rqsDTO.add(new RequestForPatientRegistrationDTO(rq));
        }
    return rqsDTO;
    }

}
