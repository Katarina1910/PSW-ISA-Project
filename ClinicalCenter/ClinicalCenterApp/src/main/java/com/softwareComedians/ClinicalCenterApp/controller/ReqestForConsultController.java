package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.RequestForConsultDTO;
import com.softwareComedians.ClinicalCenterApp.model.*;
import com.softwareComedians.ClinicalCenterApp.service.*;
import com.softwareComedians.ClinicalCenterApp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/rqForConsult")
@CrossOrigin
public class ReqestForConsultController {

    @Autowired
    private RequestForConsultService requestForConsultService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ConsultTermService consultTermService;

    @PostMapping()
    public ResponseEntity<RequestForConsultDTO> createRequest(@RequestBody RequestForConsultDTO requestForConsultDTO) {

        RequestForConsult rq = new RequestForConsult();
        rq.setId(requestForConsultDTO.getId());
        rq.setDateAndTime(requestForConsultDTO.getDateAndTime());
        rq.setType(requestForConsultDTO.getType());

        rq = requestForConsultService.save(rq);
        return new ResponseEntity<>(new RequestForConsultDTO(rq), HttpStatus.CREATED);
    }

    @PostMapping( value = "/add/{userId}")
    public ResponseEntity<?> addExamination(@RequestBody RequestForConsultDTO requestForConsultDTO,  @PathVariable Long userId) throws Exception {

        RequestForConsult rfc = new RequestForConsult();
/*
        Doctor d = doctorService.findByName(requestForConsultDTO.getConsultTerm().getDoctor().getName());
        System.out.println("Ime doktora: "+d.getName());
*/
        User u = userService.findById(userId);
        ConsultTerm ct = consultTermService.findById(requestForConsultDTO.getId());

        rfc.setId(requestForConsultDTO.getId());
        rfc.setDateAndTime(requestForConsultDTO.getDateAndTime());
        rfc.setType(requestForConsultDTO.getType());
        rfc.setAccepted(false);
        rfc.setApplicant(u);
        //rfc.setConsultTerm(ct);

/*
        if (rfc.getDuration() < 1) {
            return new ResponseEntity<>("Error! Duration is smaller then 1!", HttpStatus.METHOD_NOT_ALLOWED);
        }

        if (rfc.getPrice() < 0) {
            return new ResponseEntity<>("Error! Price is smaller then 0!", HttpStatus.METHOD_NOT_ALLOWED);
        }
        LocalDateTime dateTimeNow = LocalDateTime.now();

        int compareValue = appexm.getDateTime().compareTo(dateTimeNow);

        if (compareValue < 0) {
            return new ResponseEntity<>("Error! Date is in the past!", HttpStatus.METHOD_NOT_ALLOWED);
        }
*/
        rfc = requestForConsultService.save(rfc);

        return new ResponseEntity<>(new RequestForConsultDTO(rfc), HttpStatus.CREATED);
    }

}
