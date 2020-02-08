package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.exception.ApiRequestException;
import com.softwareComedians.ClinicalCenterApp.model.Room;
import com.softwareComedians.ClinicalCenterApp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
