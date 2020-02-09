package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.DoctorDTO;
import com.softwareComedians.ClinicalCenterApp.dto.MedicamentDTO;
import com.softwareComedians.ClinicalCenterApp.dto.RecipeDTO;
import com.softwareComedians.ClinicalCenterApp.model.Consult;
import com.softwareComedians.ClinicalCenterApp.model.Medicament;
import com.softwareComedians.ClinicalCenterApp.model.Nurse;
import com.softwareComedians.ClinicalCenterApp.model.Recipe;
import com.softwareComedians.ClinicalCenterApp.repository.ConsultRepository;
import com.softwareComedians.ClinicalCenterApp.repository.RecipeRepository;
import com.softwareComedians.ClinicalCenterApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ConsultRepository consultRepository;


    public List<RecipeDTO> getAll(Long id) {
        Nurse nurse = (Nurse) userRepository.findById(id).orElseGet(null);

        if(nurse == null)
            return null;

        List<Recipe> recipes = recipeRepository.findByClinic(nurse.getClinic().getId());
        List<RecipeDTO> recipeDTOS = new ArrayList<>();

        for(Recipe r: recipes){
            if(r.isValidated() == false) {
                RecipeDTO recipeDTO = new RecipeDTO();
                recipeDTO.setId(r.getId());
                recipeDTO.setDoctor(new DoctorDTO(r.getDoctor()));
                recipeDTO.setValidated(r.isValidated());
                List<MedicamentDTO> medicamentDTOS = new ArrayList<>();
                for (Medicament m : r.getMedicaments()) {
                    medicamentDTOS.add(new MedicamentDTO(m));
                }

                if (medicamentDTOS.size() == 0) {
                    continue;
                }

                recipeDTO.setMedicaments(medicamentDTOS);

                recipeDTOS.add(recipeDTO);
            }
        }

        return recipeDTOS;

    }

    public ResponseEntity<Void> certify(Long id, Long userid) {
        Recipe recipe = recipeRepository.findById(id).orElseGet(null);

        if(recipe == null)
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if(recipe.isValidated() == true)
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Nurse nurse = (Nurse)userRepository.findById(userid).orElseGet(null);
        recipe.setValidated(true);
        recipe.setNurse(nurse);
        Consult consult = consultRepository.findById(recipe.getConsults().getId()).orElseGet(null);
        consult.setNurse(nurse);
        consultRepository.save(consult);
        recipeRepository.save(recipe);

        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
