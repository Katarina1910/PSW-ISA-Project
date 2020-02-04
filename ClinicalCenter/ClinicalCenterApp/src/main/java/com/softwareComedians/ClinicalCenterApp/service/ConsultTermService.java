package com.softwareComedians.ClinicalCenterApp.service;
import com.softwareComedians.ClinicalCenterApp.dto.ConsultTermDTO;
import com.softwareComedians.ClinicalCenterApp.model.ConsultTerm;
import com.softwareComedians.ClinicalCenterApp.repository.ConsultTermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
