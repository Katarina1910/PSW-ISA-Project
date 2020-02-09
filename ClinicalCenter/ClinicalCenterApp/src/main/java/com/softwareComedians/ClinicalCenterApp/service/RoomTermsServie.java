package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.RoomTermsDTO;
import com.softwareComedians.ClinicalCenterApp.model.Doctor;
import com.softwareComedians.ClinicalCenterApp.model.DoctorTerms;
import com.softwareComedians.ClinicalCenterApp.model.Room;
import com.softwareComedians.ClinicalCenterApp.model.RoomTerms;
import com.softwareComedians.ClinicalCenterApp.repository.RoomTermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomTermsServie {

    @Autowired
    private RoomTermRepository roomTermRepository;

    @Autowired
    private RoomService roomService;

    @Autowired
    private DoctorTermsService doctorTermsService;

    @Autowired
    private DoctorService doctorService;

    public List<RoomTerms> findAll() { return roomTermRepository.findAll(); }


    public RoomTerms save(RoomTerms roomTerms) {
        return  roomTermRepository.save(roomTerms);
    }

    public  List<RoomTerms> findByDate(String date){
        return  roomTermRepository.findByDate(date);
    }

    public RoomTerms findOne(Long id){
        return roomTermRepository.findById(id).orElseGet(null);
    }

    public List<RoomTermsDTO> getAllDate(String date) {

        List<RoomTerms> rooms = this.findByDate(date);
        List<RoomTermsDTO> roomsTermsDTO = new ArrayList<>();
        for (RoomTerms d : rooms) {
            roomsTermsDTO.add(new RoomTermsDTO(d));
        }
    return  roomsTermsDTO;
    }

    public List<RoomTermsDTO> getAllDateRoom(String date, String room) {

        List<RoomTerms> rooms = this.findByDate(date);
        if(rooms.isEmpty()){
            for (Room r : roomService.findAll()){
                RoomTerms rt = new RoomTerms();
                rt.setRoom(r);
                rt.setDate(date);
                this.save(rt);

            }

            for(Doctor d : doctorService.findAll()){
                DoctorTerms dt = new DoctorTerms();
                dt.setDoctor(d);
                dt.setDate(date);
                doctorTermsService.save(dt);

            }
        }
        rooms = this.findByDate(date);
        List<RoomTermsDTO> roomsTermsDTO = new ArrayList<>();
        for (RoomTerms d : rooms) {
            if(d.getRoom().getName().equals(room)){
                roomsTermsDTO.add(new RoomTermsDTO(d));
            }

        }

        return roomsTermsDTO;
    }
}
