package com.softwareComedians.ClinicalCenterApp.controller;


import com.softwareComedians.ClinicalCenterApp.dto.RoomDTO;
import com.softwareComedians.ClinicalCenterApp.model.Room;
import com.softwareComedians.ClinicalCenterApp.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/rooms")
@CrossOrigin
public class RoomController {
    RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService){
        this.roomService=roomService;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<RoomDTO>> getAll() {

        List<Room> rooms = roomService.findAll();
        List<RoomDTO> roomsDTO = new ArrayList<>();
        for (Room d : rooms) {
            roomsDTO.add(new RoomDTO(d));
        }

        return new ResponseEntity<>(roomsDTO, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<RoomDTO> addRooms(@RequestBody RoomDTO roomDTO) {
        Room room = new Room();
        room.setId(roomDTO.getId());
        room.setName(roomDTO.getName());
        room.setFree(true);
        room.setType(roomDTO.getType());
        room = roomService.save(room);


        return new ResponseEntity<>(new RoomDTO(room), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/del/{id}")
    public ResponseEntity<Long> deleteRoom(@PathVariable Long id) {

        roomService.remove(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
