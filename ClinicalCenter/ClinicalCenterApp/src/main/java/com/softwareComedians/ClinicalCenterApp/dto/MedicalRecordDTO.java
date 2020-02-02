package com.softwareComedians.ClinicalCenterApp.dto;

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

}
