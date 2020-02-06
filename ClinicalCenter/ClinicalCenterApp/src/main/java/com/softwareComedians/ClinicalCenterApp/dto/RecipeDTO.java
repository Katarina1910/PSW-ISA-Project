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
}
