package com.softwareComedians.ClinicalCenterApp.model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
public class AppointedExaminations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DateTime", nullable = true)
    private Date dateTime;

    @Column(name = "Duration", nullable = false)
    private int duration; // in minutes

    @Column(name = "TypeID", nullable = false)
    private String type;

    @Column(name = "Room", nullable = false)
    private String room;

    @Column(name = "Doctor", nullable = false)
    private String doctor;

    @Column(name = "Price", nullable = false)
    private double price;

    //@Column(name = "ClinicID", nullable = false)
    //private Long clinicID;

    //@Column(name = "PatientID", nullable = false)
    //private Long patientID;

    @Column(name = "IsDone", nullable = false)
    private boolean isDone=false;

    @Column(name = "Discount", nullable = false)
    private Long discount;


    public AppointedExaminations(Long id, Date dateTime, int duration, String type, String room, String doctor,
                                 double price, Long clinicID, Long patientID, Long discount) {
        this.id = id;
        this.dateTime = dateTime;
        this.duration = duration;
        this.type = type;
        this.room = room;
        this.doctor = doctor;
        this.price = price;
        //this.clinicID = clinicID;
        //this.patientID = patientID;
        this.isDone = false;
        this.discount = discount;
    }

    public AppointedExaminations() {

    }

    public void copyValues(AppointedExaminations examination) {
        this.dateTime = examination.getDateTime();
        this.duration = examination.getDuration();
        this.type = examination.getType();
        this.room = examination.getRoom();
        this.doctor = examination.getDoctor();
        this.price = examination.getPrice();
        //this.clinicID = examination.getClinicID();
        //this.patientID = examination.getPatientID();
        this.isDone = false;
        this.discount = examination.getDiscount();
    }

    public Long getId() {
        return id;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public int getDuration() {
        return duration;
    }

    public String getType() {
        return type;
    }

    public String getRoom() {
        return room;
    }

    public String getDoctor() {
        return doctor;
    }

    public double getPrice() {
        return price;
    }
/*
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
*/
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDoctor(String doctorID) {
        this.doctor = doctorID;
    }

    public void setPrice(double price) {
        this.price = price;
    }
/*
    public void setClinicID(Long clinicID) {
        this.clinicID = clinicID;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }
*/
    public void setDone(boolean done) {
        isDone = done;
    }
}
