package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.MedicalRecordDTO;
import com.softwareComedians.ClinicalCenterApp.model.MedicalRecord;
import com.softwareComedians.ClinicalCenterApp.repository.MedicalRecordRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordDTO getByUserId(Long id) {
        MedicalRecord medicalRecord = medicalRecordRepository.findByUserId(id);

        MedicalRecordDTO medicalRecordDTO =  MedicalRecordDTO.builder()
                                            .id(medicalRecord.getId())
                                            .alergies(medicalRecord.getAlergies())
                                            .bloodType(medicalRecord.getBloodType())
                                            .diopter(medicalRecord.getDiopter())
                                            .height(medicalRecord.getHeight())
                                            .weight(medicalRecord.getWeight())
                                            .build();
        return medicalRecordDTO;
    }

    public MedicalRecord save(MedicalRecord m){return medicalRecordRepository.save(m);}

    public ResponseEntity<Void> update(MedicalRecordDTO medicalRecordDTO) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(medicalRecordDTO.getId()).orElseGet(null);

        if(medicalRecord == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{
            medicalRecord.setAlergies(medicalRecordDTO.getAlergies());
            medicalRecord.setBloodType(medicalRecordDTO.getBloodType());
            medicalRecord.setDiopter(medicalRecordDTO.getDiopter());
            medicalRecord.setHeight(medicalRecordDTO.getHeight());
            medicalRecord.setWeight(medicalRecordDTO.getWeight());
            medicalRecordRepository.save(medicalRecord);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }
}

