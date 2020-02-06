package com.softwareComedians.ClinicalCenterApp.service;
import com.softwareComedians.ClinicalCenterApp.dto.ConsultTermDTO;
import com.softwareComedians.ClinicalCenterApp.model.*;
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

    @Autowired
    private  RequestForConsultService requestForConsultService;

    @Autowired
    private RoomTermsServie roomTermsServie;

    @Autowired
    private DoctorTermsService doctorTermsService;

    @Autowired
    private RoomService roomService;


    @Autowired
    private ConsultTermService consultTermService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ClinicsService clinicsService;


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

    public ConsultTerm reserveRoom(String date, String term,String room, Long doctor, Long id){
        ConsultTerm ct = new ConsultTerm();
        RequestForConsult rq = requestForConsultService.findById(id);

        List<RoomTerms> rts= roomTermsServie.findByDate(date);
        List<DoctorTerms> dts = doctorTermsService.findByDate(date);
        DoctorTerms dt = null;
        RoomTerms r = null;
        for (RoomTerms rr : rts){
            if(rr.getRoom().getName().equals(room)){
                r=rr;
                System.out.println(r.getRoom().getName());
            }
        }

        for(DoctorTerms d : dts){
            if(d.getDoctor().getId() == doctor){
                dt = d;
            }
        }


        if(term.equals("07:00-09:00")){
            r.setTerm1(false);
            dt.setTerm1(false);
        }else if(term.equals("09:00-11:00")){
            r.setTerm2(false);
            dt.setTerm2(false);
        }else if(term.equals("11:00-13:00")){
            r.setTerm3(false);
            dt.setTerm3(false);
        }
        else if(term.equals("13:00-15:00")){
            r.setTerm4(false);
            dt.setTerm4(false);
        }else if(term.equals("15:00-17:00")){
            r.setTerm5(false);
            dt.setTerm5(false);
        }else if(term.equals("17:00-19:00")){
            r.setTerm6(false);
            dt.setTerm6(false);
        }
        roomTermsServie.save(r);
        doctorTermsService.save(dt);

        ct.setType(rq.getType());
        ct.setRoom(roomService.findByName(room));
        ct.setRequestForConsult(rq);
        ct.setPatient((Patient) rq.getPatient());
        ct.setDate(date);
        ct.setPrice((double) 0);
        ct.setDuration((double) 2);
        ct.setDiscount((double) 0);

        Doctor doc = doctorService.findOne(doctor);
        ct.setDoctor(doc);
        ct.setClinic(clinicsService.findOne(doc.getClinic().getId()));

        System.out.println(ct.getDate()+ ct.getType().getName()+ ct.getDoctor().getName()+ ct.getPatient().getName()+ct.getRoom().getName()+
                ct.getClinic().getName()+ct.getRequestForConsult().getId());

        ct = consultTermService.save(ct);
        return ct;
    }


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
