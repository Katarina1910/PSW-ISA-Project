package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.Operation;
import com.softwareComedians.ClinicalCenterApp.model.Room;
import com.softwareComedians.ClinicalCenterApp.repository.OperationRepository;
import com.softwareComedians.ClinicalCenterApp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private OperationRepository operationRepository;

    public Room findOne(Long id){
        return roomRepository.findById(id).orElseGet(null);
    }

    public List<Room> findAll(){
        return roomRepository .findAll();
    }

    public Room save(Room r) {
        return roomRepository.save(r);
    }

    public Operation saveOperation(Operation o) { return  operationRepository.save(o); }

    public void remove(Long id){
        roomRepository.deleteById(id);
    }

    public Room findByName(String s) {
        return roomRepository.findByName(s);
    }

}
