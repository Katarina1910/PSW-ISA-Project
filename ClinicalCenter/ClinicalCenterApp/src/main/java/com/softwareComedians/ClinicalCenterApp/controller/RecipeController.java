package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.RecipeDTO;
import com.softwareComedians.ClinicalCenterApp.model.Recipe;
import com.softwareComedians.ClinicalCenterApp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping(value = "/api/recipe/")
@CrossOrigin
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping(value = "getAll/{id}")
    public ResponseEntity<List<RecipeDTO>> getAll(@PathVariable Long id){
        List<RecipeDTO> recipeDTOS = recipeService.getAll(id);
        if(recipeDTOS == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(recipeDTOS, HttpStatus.OK);
        }

    }

    @GetMapping(value = "certify/{id}")
    public ResponseEntity<Void> certify(@PathVariable Long id){
            return recipeService.certify(id);
    }

}
