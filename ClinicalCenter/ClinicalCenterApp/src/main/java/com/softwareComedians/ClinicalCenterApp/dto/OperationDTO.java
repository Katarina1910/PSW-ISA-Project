package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.Doctor;
import com.softwareComedians.ClinicalCenterApp.model.Operation;
import com.softwareComedians.ClinicalCenterApp.model.Room;

public class OperationDTO {

    private Long id;
    private RoomDTO room;
    private RequestForOperationDTO requestForOperation;
    private DoctorDTO doctor;

    public OperationDTO() {
    }

    public OperationDTO(Long id, RoomDTO r, RequestForOperationDTO rq,  DoctorDTO doctorDTO) {
        this.id = id;
        this.room = r;
        this.requestForOperation = rq;
        this.doctor = doctorDTO;
    }

    public OperationDTO(Operation operation){
        System.out.println(operation.getId() + " " + operation.getRoom().getName() + " " + operation.getRequstForOperation()+" "+ operation.getDoctor().getName());
        this.id= operation.getId();
        this.room = new RoomDTO(operation.getRoom());
        this.requestForOperation = new RequestForOperationDTO(operation.getRequstForOperation());
        this.doctor = new DoctorDTO(operation.getDoctor());
    }

    public OperationDTO(Long id, Room room, Doctor doctor){
        this.id= id;
        this.room = new RoomDTO(room);
        this.doctor = new DoctorDTO(doctor);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomDTO getRoom() {
        return room;
    }

    public void setRoom(RoomDTO room) {
        this.room = room;
    }

    public RequestForOperationDTO getRequestForOperation() {
        return requestForOperation;
    }

    public void setRequestForOperation(RequestForOperationDTO requestForOperation) {
        this.requestForOperation = requestForOperation;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }
}
