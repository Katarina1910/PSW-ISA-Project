package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.DoctorTerms;
import com.softwareComedians.ClinicalCenterApp.repository.DoctorTermsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorTermsService {

    @Autowired
    private DoctorTermsRepository doctorTermsRepository;

    public List<DoctorTerms> findAll() { return doctorTermsRepository.findAll(); }

    public DoctorTerms save(DoctorTerms doctorTerms) {
        return  doctorTermsRepository.save(doctorTerms);
    }
    public List<DoctorTerms> findByDate(String date){
        return  doctorTermsRepository.findByDate(date);
    }

}
