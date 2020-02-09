package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.RoomDTO;
import com.softwareComedians.ClinicalCenterApp.exception.ApiRequestException;
import com.softwareComedians.ClinicalCenterApp.model.Room;
import com.softwareComedians.ClinicalCenterApp.model.Type;
import com.softwareComedians.ClinicalCenterApp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;



    public Room findOne(Long id){
        try {
            return roomRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ApiRequestException("Room with id '" + id + "' doesn't exist.");
        }
    }

    public List<Room> findAll(){
        return roomRepository .findAll();
    }

    public Room save(Room r) {
        return roomRepository.save(r);
    }


    public void remove(Long id){
        roomRepository.deleteById(id);
    }

    public Room findByName(String s) {
        return roomRepository.findByName(s);
    }

    public List<RoomDTO> getAll() {

        List<Room> rooms = this.findAll();
        List<RoomDTO> roomsDTO = new ArrayList<>();
        for (Room d : rooms) {
            roomsDTO.add(new RoomDTO(d));
        }
        return roomsDTO;
    }

    public List<RoomDTO> getEx() {

        List<Room> rooms = this.findAll();
        List<RoomDTO> roomsDTO = new ArrayList<>();
        for (Room d : rooms) {
            if(d.getType().equals(Type.examination)){
                roomsDTO.add(new RoomDTO(d));
            }

        }
        return  roomsDTO;
    }

    public List<RoomDTO> getOp() {

        List<Room> rooms = this.findAll();
        List<RoomDTO> roomsDTO = new ArrayList<>();
        for (Room d : rooms) {
            if(d.getType().equals(Type.operation)){
                roomsDTO.add(new RoomDTO(d));
            }

        }
    return roomsDTO;
    }

    public Room addRooms(RoomDTO roomDTO) {
        Room room = new Room();
        room.setId(roomDTO.getId());
        room.setName(roomDTO.getName());
        room.setType(roomDTO.getType());
        room = this.save(room);
        return room;
    }

    public Room editRoom ( RoomDTO roomDTO) {
        Room room = this.findOne(roomDTO.getId());
        room.setName(roomDTO.getName());
        room.setType(roomDTO.getType());
        room = this.save(room);
        return room;
    }

}
