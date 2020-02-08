package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.OperationDTO;
import com.softwareComedians.ClinicalCenterApp.model.Operation;
import com.softwareComedians.ClinicalCenterApp.service.DoctorService;
import com.softwareComedians.ClinicalCenterApp.service.OperationService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/operations")
@CrossOrigin
public class OperationController {

    @Autowired
    private OperationService operationService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping(value="/getAll/{id}")
    public ResponseEntity<List<OperationDTO>> getAll(@PathVariable Long id) {

        //List<Operation> operations = doctorService.findAllByUserId(id);
        List<OperationDTO> operationDTOS = new ArrayList<>();
        //for (Operation o : operations) {
          //  operationDTOS.add(new OperationDTO(o));
        //}

        return new ResponseEntity<>(operationDTOS, HttpStatus.OK);
    }
}
