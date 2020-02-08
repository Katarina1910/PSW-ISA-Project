package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.RequestForAbsence;
import com.softwareComedians.ClinicalCenterApp.repository.RqAbsenceRepository;
import com.softwareComedians.ClinicalCenterApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
