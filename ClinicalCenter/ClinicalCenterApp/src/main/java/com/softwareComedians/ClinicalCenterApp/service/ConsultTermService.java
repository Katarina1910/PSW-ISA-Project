package com.softwareComedians.ClinicalCenterApp.service;
import com.softwareComedians.ClinicalCenterApp.dto.ConsultTermDTO;
import com.softwareComedians.ClinicalCenterApp.dto.MedicamentDTO;
import com.softwareComedians.ClinicalCenterApp.model.ConsultTerm;
import com.softwareComedians.ClinicalCenterApp.model.Diagnosis;
import com.softwareComedians.ClinicalCenterApp.model.Medicament;
import com.softwareComedians.ClinicalCenterApp.model.Recipe;
import com.softwareComedians.ClinicalCenterApp.repository.ConsultTermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ConsultTermService {
    @Autowired
    private ConsultTermRepository consultTermRepository;

    public ConsultTerm save(ConsultTerm consultTerm) {
        return consultTermRepository.save(consultTerm);
    }

    public void remove(Long id){
        consultTermRepository.deleteById(id);
    }

    public List<ConsultTerm> findAll() {
        return consultTermRepository.findAll();
    }

    public List<ConsultTerm> findByTypeName(String typeName) {
        return consultTermRepository.findByTypeName(typeName);
    }

    public ConsultTerm findById(Long id) {
        return consultTermRepository.findById(id).orElse(null);
    }

    public List<ConsultTermDTO> getConsultsByUser(Long id, String role) {
        List<ConsultTerm> consultTerms = new ArrayList<>();
        List<ConsultTermDTO> consultTermsDTO = new ArrayList<>();

        if(role.equals("ROLE_DOCTOR")){
            consultTerms = consultTermRepository.getConsultsDoctor(id);
        }else if(role.equals("ROLE_NURSE")){
           // consultTerms = consultTermRepository.getConsultsNurse(id);
        }

        for (ConsultTerm ct : consultTerms) {
            System.out.println(ct.getId());
            consultTermsDTO.add(new ConsultTermDTO(ct));
        }

        return consultTermsDTO;
    }


    public ResponseEntity<Void> addReport(ConsultTermDTO consultTermDTO) {
            ConsultTerm consultTerm = consultTermRepository.findById(consultTermDTO.getId()).orElseGet(null);
            if(consultTerm == null){
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                Diagnosis diagnosis = Diagnosis.builder()
                        .id(consultTermDTO.getDiagnosis().getId())
                        .build();
                Recipe recipe =  new Recipe();
                recipe.setValidated(false);
                Set<Medicament> medicaments = new HashSet<>();
                for(MedicamentDTO m: consultTermDTO.getRecipe().getMedicaments()){
                    Medicament medicament = Medicament.builder()
                            .id(m.getId())
                            .build();
                    medicaments.add(medicament);
                }

                recipe.setMedicaments(medicaments);
                recipe.setDoctor(consultTerm.getDoctor());
                recipe.setMedicalRecord(consultTerm.getPatient().getMedicalRecord());

                consultTerm.setReport(consultTermDTO.getReport());
                consultTerm.setDiagnosis(diagnosis);
                consultTerm.setRecipe(recipe);

                consultTermRepository.save(consultTerm);
                return new ResponseEntity<>(HttpStatus.OK);
            }
    }

    }
