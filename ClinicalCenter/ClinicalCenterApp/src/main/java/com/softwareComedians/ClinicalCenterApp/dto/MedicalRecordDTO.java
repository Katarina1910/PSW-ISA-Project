package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.MedicalRecord;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecordDTO {

    private Long id;
    private String height;
    private String weight;
    private String bloodType;
    private String diopter;
    private String alergies;
    private String historyDisease;
    private PatientDTO patient;

    public MedicalRecordDTO(MedicalRecord medicalRecord) {
        this.id = medicalRecord.getId();
        this.alergies = medicalRecord.getAlergies();
         this.bloodType = medicalRecord.getBloodType();
         this.diopter=medicalRecord.getDiopter();
         this.height=medicalRecord.getHeight();
         this.weight=medicalRecord.getWeight();
         System.out.println("napravio"+ medicalRecord.getId());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getDiopter() {
        return diopter;
    }

    public void setDiopter(String diopter) {
        this.diopter = diopter;
    }

    public String getAlergies() {
        return alergies;
    }

    public void setAlergies(String alergies) {
        this.alergies = alergies;
    }

    public String getHistoryDisease() {
        return historyDisease;
    }

    public void setHistoryDisease(String historyDisease) {
        this.historyDisease = historyDisease;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }
}
