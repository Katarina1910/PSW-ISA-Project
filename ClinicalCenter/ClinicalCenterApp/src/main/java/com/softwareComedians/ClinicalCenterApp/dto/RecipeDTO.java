package com.softwareComedians.ClinicalCenterApp.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDTO {
    private Long id;
    private NurseDTO nurse;
    private ConsultTermDTO consultTerm;
    private List<MedicamentDTO> medicaments;
    private boolean isValidated;
    private DoctorDTO doctor;
    private MedicalRecordDTO medicalRecord;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NurseDTO getNurse() {
        return nurse;
    }

    public void setNurse(NurseDTO nurse) {
        this.nurse = nurse;
    }

    public ConsultTermDTO getConsultTerm() {
        return consultTerm;
    }

    public void setConsultTerm(ConsultTermDTO consultTerm) {
        this.consultTerm = consultTerm;
    }

    public List<MedicamentDTO> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(List<MedicamentDTO> medicaments) {
        this.medicaments = medicaments;
    }

    public boolean isValidated() {
        return isValidated;
    }

    public void setValidated(boolean validated) {
        isValidated = validated;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }

    public MedicalRecordDTO getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecordDTO medicalRecord) {
        this.medicalRecord = medicalRecord;
    }
}
