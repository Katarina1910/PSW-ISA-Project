package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.Room;
import com.softwareComedians.ClinicalCenterApp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room findOne(Long id){
        return roomRepository.findById(id).orElseGet(null);
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

}
