package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.Room;
import com.softwareComedians.ClinicalCenterApp.model.Type;



public class RoomDTO {
    private Long id;
    private Type type;
    private boolean isFree;
    private String name;

    public RoomDTO() {
    }

    public RoomDTO(Long id, Type type, boolean isFree, String name) {
        this.id = id;
        this.type = type;
        this.isFree = isFree;
        this.name = name;
    }
    public RoomDTO(Room room){
        this.id= room.getId();
        this.type=room.getType();
        this.isFree = room.isFree();
        this.name = room.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
