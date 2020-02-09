package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.ConsultDTO;
import com.softwareComedians.ClinicalCenterApp.dto.ConsultTermDTO;
import com.softwareComedians.ClinicalCenterApp.dto.MedicamentDTO;
import com.softwareComedians.ClinicalCenterApp.exception.ApiRequestException;
import com.softwareComedians.ClinicalCenterApp.model.*;
import com.softwareComedians.ClinicalCenterApp.repository.*;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ConsultTermService {

    @Autowired
    ConsultRepository consultRepository;

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
    private UserRepository userRepository;

    @Autowired
    private ConsultTermService consultTermService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ClinicsService clinicsService;

    @Autowired
    private  PatientService patientService;

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    private MedicamentRepository medicamentRepository;


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
        try {
            return consultTermRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ApiRequestException("Consult term with id '" + id + "' doesn't exist.");
        }
    }

    public ConsultTermDTO findByIdDTO(Long id) {
        try {
            return new ConsultTermDTO(consultTermRepository.findById(id).get());
        } catch (NoSuchElementException e) {
            throw new ApiRequestException("Consult term with id '" + id + "' doesn't exist.");
        }
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
        Patient p = patientService.findById(rq.getPatient().getId());
        ct.setPatient(p);
        ct.setDate(date);
        ct.setPrice((double) 0);
        ct.setDuration((double) 2);
        ct.setDiscount((double) 0);

        Doctor doc = doctorService.findOne(doctor);
        ct.setDoctor(doc);
        ct.setClinic(clinicsService.findOne(doc.getClinic().getId()));

        /*System.out.println(ct.getDate()+ ct.getType().getName()+ ct.getDoctor().getName()+ ct.getPatient().getName()+ct.getRoom().getName()+
                ct.getClinic().getName()+ct.getRequestForConsult().getId());*/

        ct = consultTermService.save(ct);
        return ct;
    }

    public ResponseEntity<Void> addReport(ConsultDTO consultDTO) {
            Consult consult = new Consult();
            consult.setReport(consultDTO.getReport());
            ConsultTerm consultTerm = consultTermRepository.findById(consultDTO.getConsultTerm().getId()).orElseGet(null);

            if(consultTerm == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            consultTerm.setReport(consultDTO.getReport());
            consult.setConsultTerm(consultTerm);
            consult.setReport(consultDTO.getReport());
            consult.setDiagnosis(new Diagnosis(consultDTO.getDiagnosis()));
            Recipe recipe = new Recipe();
            Set<Medicament> medicaments =  new HashSet<>();
            for(MedicamentDTO m: consultDTO.getRecipe().getMedicaments()){
                Medicament medicament = medicamentRepository.findById(m.getId()).orElseGet(null);
                if (medicament != null) {
                    medicaments.add(medicament);
                }
            }
            recipe.setMedicaments(medicaments);
            Doctor doctor = (Doctor) userRepository.findById(consultDTO.getConsultTerm().getDoctor().getId()).orElseGet(null);
            recipe.setDoctor(doctor);
            consult.setRecipe(recipe);
            Patient patient = (Patient) userRepository.findById(consultDTO.getConsultTerm().getPatient().getId()).orElseGet(null);
            Optional<MedicalRecord> optionalMedicalRecord= medicalRecordRepository.findById(patient.getMedicalRecord().getId());
            if(optionalMedicalRecord.isPresent()) {
                MedicalRecord medicalRecord = optionalMedicalRecord.get();
                consult.setMedicalRecord(medicalRecord);
                recipe.setMedicalRecord(medicalRecord);
            }
            Clinic clinic = clinicsService.findById(doctor.getClinic().getId());
            clinic.setIncome(clinic.getIncome()+consultTerm.getPrice());
            clinicsService.save(clinic);

            recipeRepository.save(recipe);
            consultRepository.save(consult);

            return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> editConsult(ConsultDTO consultDTO) {
        Consult consult = consultRepository.findById(consultDTO.getId()).orElseGet(null);
        if(consult == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Diagnosis diagnosis = diagnosisRepository.findById(consultDTO.getDiagnosis().getId()).orElseGet(null);
        consult.setDiagnosis(diagnosis);
        consult.setReport(consultDTO.getReport());

        consultRepository.save(consult);

        return  new ResponseEntity<>(HttpStatus.OK);

    }
}

