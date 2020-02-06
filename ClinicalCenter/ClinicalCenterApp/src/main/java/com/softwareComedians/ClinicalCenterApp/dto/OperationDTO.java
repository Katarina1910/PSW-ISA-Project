package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.Operation;

public class OperationDTO {

    private Long id;
    private RoomDTO room;
    private RequestForOperationDTO requestForOperation;

    public OperationDTO() {
    }

    public OperationDTO(Long id, RoomDTO r, RequestForOperationDTO rq) {
        this.id = id;
        this.room = r;
        this.requestForOperation = rq;
    }

    public OperationDTO(Operation operation){
        this.id= room.getId();
        this.room = new RoomDTO(operation.getRoom());
        this.requestForOperation = new RequestForOperationDTO(operation.getRequstForOperation());
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
}
