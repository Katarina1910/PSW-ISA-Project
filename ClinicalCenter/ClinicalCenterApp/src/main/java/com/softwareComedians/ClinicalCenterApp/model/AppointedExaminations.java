package com.softwareComedians.ClinicalCenterApp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AppointedExaminations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DateTime", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "Duration", nullable = false)
    private int duration; // u minutes

    @Column(name = "TypeID", nullable = false)
    private Long typeID;

    @Column(name = "RoomID", nullable = false)
    private Long roomID;

    @Column(name = "DoctorID", nullable = false)
    private Long doctorID;

    @Column(name = "Price", nullable = false)
    private double price;

    @Column(name = "ClinicID", nullable = false)
    private Long clinicID;

    @Column(name = "PatientID", nullable = false)
    private Long patientID;

    @Column(name = "IsDone", nullable = false)
    private boolean isDone=false;


    public AppointedExaminations(Long id, LocalDateTime dateTime, int duration, Long typeID, Long roomID, Long doctorID, double price, Long clinicID, Long patientID) {
        this.id = id;
        this.dateTime = dateTime;
        this.duration = duration;
        this.typeID = typeID;
        this.roomID = roomID;
        this.doctorID = doctorID;
        this.price = price;
        this.clinicID = clinicID;
        this.patientID = patientID;
        this.isDone = false;
    }

    public AppointedExaminations() {

    }

    public void copyValues(AppointedExaminations examination) {
        this.dateTime = examination.getDateTime();
        this.duration = examination.getDuration();
        this.typeID = examination.getTypeID();
        this.roomID = examination.getRoomID();
        this.doctorID = examination.getDoctorID();
        this.price = examination.getPrice();
        this.clinicID = examination.getClinicID();
        this.patientID = examination.getPatientID();
        this.isDone = false;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getDuration() {
        return duration;
    }

    public Long getTypeID() {
        return typeID;
    }

    public Long getRoomID() {
        return roomID;
    }

    public Long getDoctorID() {
        return doctorID;
    }

    public double getPrice() {
        return price;
    }

    public Long getClinicID() {
        return clinicID;
    }

    public Long getPatientID() {
        return patientID;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTypeID(Long typeID) {
        this.typeID = typeID;
    }

    public void setRoomID(Long roomID) {
        this.roomID = roomID;
    }

    public void setDoctorID(Long doctorID) {
        this.doctorID = doctorID;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setClinicID(Long clinicID) {
        this.clinicID = clinicID;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
