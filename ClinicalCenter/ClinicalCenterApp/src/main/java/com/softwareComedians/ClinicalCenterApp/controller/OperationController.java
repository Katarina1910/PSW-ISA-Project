package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.OperationDTO;
import com.softwareComedians.ClinicalCenterApp.model.Operation;
import com.softwareComedians.ClinicalCenterApp.service.DoctorService;
import com.softwareComedians.ClinicalCenterApp.service.OperationService;
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

        List<Operation> operations = operationService.finAll();
        List<OperationDTO> operationDTOS = new ArrayList<>();
        for (Operation o : operations) {
            System.out.println(o.getDoctor().getName()+"for");
            System.out.println(id+"jebem ti sunce");
            System.out.println(o.getDoctor().getId()+"govno");
            if(o.getDoctor().getId()==id){
                System.out.println(o.getDoctor().getName() + "if");
                    operationDTOS.add(new OperationDTO(o.getId(), o.getRoom(), o.getDoctor()));
            }
        }

        return new ResponseEntity<>(operationDTOS, HttpStatus.OK);
    }
}
