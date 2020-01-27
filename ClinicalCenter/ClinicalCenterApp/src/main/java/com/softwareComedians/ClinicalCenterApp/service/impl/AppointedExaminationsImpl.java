package com.softwareComedians.ClinicalCenterApp.service.impl;

import com.softwareComedians.ClinicalCenterApp.model.AppointedExaminations;
import com.softwareComedians.ClinicalCenterApp.repository.AppointedExaminationsRepository;
import com.softwareComedians.ClinicalCenterApp.service.AppointedExaminationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AppointedExaminationsImpl implements AppointedExaminationsService {

    @Autowired
    private AppointedExaminationsRepository appointedExaminationsRepository;


    @Override
    public Collection<AppointedExaminations> findAll() {
        return appointedExaminationsRepository.findAll();
    }
/*
    @Override
    public Collection<AppointedExaminations> findByIdDoctor(Long id) {
        return appointedExaminationsRepository.findByIdDoctor(id);
    }

    @Override
    public Collection<AppointedExaminations> findByIdPatient(Long id) {
        return appointedExaminationsRepository.findByIdPatient(id);
    }
*/
    @Override
    public AppointedExaminations findById(Long id)  {
        return appointedExaminationsRepository.findById(id).orElse(null);
    }

    @Override
    public AppointedExaminations update(AppointedExaminations patient) throws Exception {
        AppointedExaminations forChange = findById(patient.getId());
        forChange.copyValues(patient);
        forChange = appointedExaminationsRepository.save(forChange);
        return forChange;
    }

    @Override
    public AppointedExaminations create(AppointedExaminations examination) throws Exception {
        AppointedExaminations ret = new AppointedExaminations();

        ret.setDateTime(examination.getDateTime());
        ret.setPrice(examination.getPrice());
        ret.setDuration(examination.getDuration());
        //ret.setClinicID(examination.getClinicID());
        ret.setDoctor(examination.getDoctor());
        ret.setType(examination.getType());
        //ret.setPatientID(examination.getPatientID());
        ret.setRoom(examination.getRoom());

        ret = this.appointedExaminationsRepository.save(ret);
        return ret;
    }

    @Override
    public void delete(Long id) {
        appointedExaminationsRepository.deleteById(id);
    }

    public AppointedExaminations save(AppointedExaminations consultTerm) {
        return appointedExaminationsRepository.save(consultTerm);
    }
}
