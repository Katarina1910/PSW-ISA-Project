package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.AppointedExaminations;

import java.util.Collection;

public interface AppointedExaminationsService {

        Collection<AppointedExaminations> findAll();
        //Collection<AppointedExaminations> findByIdDoctor(Long id);
        //Collection<AppointedExaminations> findByIdPatient(Long id);
        AppointedExaminations findById(Long id);
        AppointedExaminations update(AppointedExaminations patient) throws Exception;
        AppointedExaminations create(AppointedExaminations examinations) throws Exception;
        void delete(Long id);
}
