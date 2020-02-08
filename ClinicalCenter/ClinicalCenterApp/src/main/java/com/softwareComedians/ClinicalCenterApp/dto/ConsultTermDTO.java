package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.ConsultTerm;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class ConsultTermDTO {
    private  ConsultTypeDTO type;
    private Long id;
    private String date;
    private  Double duration;
    private  Double price;
    private String report;
    private  Double discount;
    private PatientDTO patient;
    private  DoctorDTO doctor;
    private  RoomDTO room;
    private Long clinicId;
    private  Long typeId;

    public ConsultTermDTO() {
    }

    public ConsultTermDTO(ConsultTypeDTO type, Long id, String date, Double duration, Double price, Double discount,
                          DoctorDTO doctor, RoomDTO room, Long clinicId) {
        this.type = type;
        this.id = id;
        this.date = date;
        this.duration = duration;
        this.price = price;
        this.discount = discount;
        this.doctor = doctor;
        this.room = room;
        this.clinicId = clinicId;
    }
   
    public ConsultTermDTO(ConsultTerm c){
        id=c.getId();
        report = c.getReport();
        type = new ConsultTypeDTO(c.getType());
        date = c.getDate();
        duration=c.getDuration();
        price=c.getPrice();
        discount=c.getDiscount();
        doctor = new DoctorDTO(c.getDoctor());
        room = new RoomDTO(c.getRoom());
        patient = new PatientDTO(c.getPatient());
        clinicId = c.getClinic().getId();
    }

    public Long getClinicId() {
        return clinicId;
    }

    public void setClinicId(Long clinicId) {
        this.clinicId = clinicId;
    }

    public ConsultTypeDTO getType() {
        return type;
    }

    public void setType(ConsultTypeDTO type) {
        this.type = type;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }

    public RoomDTO getRoom() {
        return room;
    }

    public void setRoom(RoomDTO room) {
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

}
