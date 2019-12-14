package com.softwareComedians.ClinicalCenterApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.softwareComedians.ClinicalCenterApp.dto.MedicamentDTO;
import com.softwareComedians.ClinicalCenterApp.model.Medicament;
import com.softwareComedians.ClinicalCenterApp.service.MedicamentService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/medicaments")
@CrossOrigin
public class MedicamentController {

    MedicamentService medicamentService;

    @Autowired
    public MedicamentController(MedicamentService medicamentService){this.medicamentService = medicamentService;}

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<MedicamentDTO>> getAll(){

        List<Medicament> medicaments = medicamentService.findAll();
        List<MedicamentDTO> medicamentDTOS = new ArrayList<>();
        for(Medicament m:medicaments){
            medicamentDTOS.add(new MedicamentDTO(m));
        }
        return new ResponseEntity<>(medicamentDTOS, HttpStatus.OK);
    }

    @PostMapping()
    public  ResponseEntity<MedicamentDTO> addMedicament(@RequestBody MedicamentDTO medicamentDTO){
        Medicament medicament = new Medicament(medicamentDTO);
        medicament = medicamentService.save(medicament);

        return new ResponseEntity<>(new MedicamentDTO(medicament), HttpStatus.OK);
    }

    @DeleteMapping(value = "/del/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id){

        medicamentService.remove(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<MedicamentDTO> editMedicament (@RequestBody MedicamentDTO medicamentDTO) {
        Medicament m = medicamentService.findOne(medicamentDTO.getId());
        m.setName(medicamentDTO.getName());
        m.setCode(medicamentDTO.getCode());
        m.setDescription((medicamentDTO.getDescription()));
        m = medicamentService.save(m);

        return new ResponseEntity<>(new MedicamentDTO(m), HttpStatus.OK);
    }
}
