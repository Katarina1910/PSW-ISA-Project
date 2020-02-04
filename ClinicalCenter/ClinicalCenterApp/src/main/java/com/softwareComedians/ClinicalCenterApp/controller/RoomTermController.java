package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.RoomDTO;
import com.softwareComedians.ClinicalCenterApp.dto.RoomTermsDTO;
import com.softwareComedians.ClinicalCenterApp.model.Room;
import com.softwareComedians.ClinicalCenterApp.model.RoomTerms;
import com.softwareComedians.ClinicalCenterApp.service.RoomService;
import com.softwareComedians.ClinicalCenterApp.service.RoomTermsServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/roomTerms")
@CrossOrigin
public class RoomTermController {
    RoomTermsServie roomTermsServie;

    @Autowired
    public RoomTermController(RoomTermsServie roomTermsServie){
        this.roomTermsServie=roomTermsServie;
    }

    @GetMapping(value = "/getAllDate/{date}")
    public ResponseEntity<List<RoomTermsDTO>> getAll(@PathVariable String date) {

        List<RoomTerms> rooms = roomTermsServie.findByDate(date);
        List<RoomTermsDTO> roomsTermsDTO = new ArrayList<>();
        for (RoomTerms d : rooms) {
            roomsTermsDTO.add(new RoomTermsDTO(d));
        }

        return new ResponseEntity<>(roomsTermsDTO, HttpStatus.OK);
    }

}
