package com.softwareComedians.ClinicalCenterApp.dto;

public class ConsultDTO {
    private Long id;
    private ConsultTermDTO consultTerm;
    private RecipeDTO recipe;
    private NurseDTO nurse;
    private DiagnosisDTO diagnosis;
    private String report;
    private MedicalRecordDTO medicalRecord;

    public void setId(Long id) {
        this.id = id;
    }

    public void setConsultTerm(ConsultTermDTO consultTerm) {
        this.consultTerm = consultTerm;
    }

    public void setRecipe(RecipeDTO recipe) {
        this.recipe = recipe;
    }

    public void setNurse(NurseDTO nurse) {
        this.nurse = nurse;
    }

    public void setDiagnosis(DiagnosisDTO diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public void setMedicalRecord(MedicalRecordDTO medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public Long getId() {
        return id;
    }

    public ConsultTermDTO getConsultTerm() {
        return consultTerm;
    }

    public RecipeDTO getRecipe() {
        return recipe;
    }

    public NurseDTO getNurse() {
        return nurse;
    }

    public DiagnosisDTO getDiagnosis() {
        return diagnosis;
    }

    public String getReport() {
        return report;
    }

    public MedicalRecordDTO getMedicalRecord() {
        return medicalRecord;
    }
}
