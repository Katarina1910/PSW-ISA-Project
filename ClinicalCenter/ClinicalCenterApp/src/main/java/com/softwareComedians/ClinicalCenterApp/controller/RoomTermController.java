package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.RoomTermsDTO;
import com.softwareComedians.ClinicalCenterApp.service.RoomTermsServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<RoomTermsDTO>> getAllDate(@PathVariable String date) {
        List<RoomTermsDTO> roomsTermsDTO = roomTermsServie.getAllDate(date);
        return new ResponseEntity<>(roomsTermsDTO, HttpStatus.OK);
    }


    @GetMapping(value = "/getAllDate/{date}/{room}")
    public ResponseEntity<List<RoomTermsDTO>> getAllDateRoom(@PathVariable String date, @PathVariable String room) {
        List<RoomTermsDTO> roomsTermsDTO = roomTermsServie.getAllDateRoom(date,room);
        return new ResponseEntity<>(roomsTermsDTO, HttpStatus.OK);
    }

}
