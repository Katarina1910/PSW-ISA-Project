package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.ConsultDTO;
import com.softwareComedians.ClinicalCenterApp.dto.ConsultTermDTO;
import com.softwareComedians.ClinicalCenterApp.dto.MedicamentDTO;
import com.softwareComedians.ClinicalCenterApp.exception.ApiRequestException;
import com.softwareComedians.ClinicalCenterApp.mail.SmtpMailSender;
import com.softwareComedians.ClinicalCenterApp.model.*;
import com.softwareComedians.ClinicalCenterApp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.*;

@Service
public class ConsultTermService {

    @Autowired
    ConsultRepository consultRepository;

    @Autowired
    private SmtpMailSender smtpMailSender;

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
    private  ConsultTypeService consultTypeService;

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
        rq.setAccepted(true);

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


    public ResponseEntity<Void> editConsult(ConsultDTO consultDTO) throws MessagingException {
        Consult consult = consultRepository.findById(consultDTO.getId()).orElseGet(null);
        if (consult == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Diagnosis diagnosis = diagnosisRepository.findById(consultDTO.getDiagnosis().getId()).orElseGet(null);
        consult.setDiagnosis(diagnosis);
        consult.setReport(consultDTO.getReport());

        consultRepository.save(consult);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @Scheduled(cron = "00 00 * * * *")
    public void reservingRooms() throws MessagingException {

        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "reserve rooms automatically - " + now);

        String date = null;
        DoctorTerms dt = null;
        RoomTerms r = null;
        List<RoomTerms> rts = null;
        List<DoctorTerms> dts = null;
        Room room = null;
        Doctor doctor = null;

        List<RequestForConsult> requestForConsults = requestForConsultService.findAll();
        for (RequestForConsult rq : requestForConsults) {
            ConsultTerm ct = new ConsultTerm();
            date = rq.getDateAndTime();
            dts = doctorTermsService.findByDate(date);


            for (DoctorTerms dd : dts) {
                if (dd.getDate().equals(date)) {
                    dt = dd;
                    if (dt.isTerm1()) {
                        doctor = dt.getDoctor();
                        dt.setTerm1(false);
                        doctorTermsService.save(dt);
                        break;
                    } else if (dt.isTerm2()) {
                        doctor = dt.getDoctor();
                        dt.setTerm2(false);
                        doctorTermsService.save(dt);
                        break;
                    } else if (dt.isTerm3()) {
                        doctor = dt.getDoctor();
                        dt.setTerm3(false);
                        doctorTermsService.save(dt);
                        break;
                    } else if (dt.isTerm4()) {
                        doctor = dt.getDoctor();
                        dt.setTerm4(false);
                        doctorTermsService.save(dt);
                        break;
                    } else if (dt.isTerm5()) {
                        doctor = dt.getDoctor();
                        dt.setTerm5(false);
                        doctorTermsService.save(dt);
                        break;
                    } else if (dt.isTerm6()) {
                        doctor = dt.getDoctor();
                        dt.setTerm6(false);
                        doctorTermsService.save(dt);
                        break;
                    }

                }
            }

            if (doctor == null) {
                for (DoctorTerms dd : dts) {
                    dt = dd;
                    if (dt.isTerm1()) {
                        doctor = dt.getDoctor();
                        dt.setTerm1(false);
                        doctorTermsService.save(dt);
                        date = dt.getDate();
                        break;

                    } else if (dt.isTerm2()) {
                        doctor = dt.getDoctor();
                        dt.setTerm2(false);
                        doctorTermsService.save(dt);
                        date = dt.getDate();
                        break;
                    } else if (dt.isTerm3()) {
                        doctor = dt.getDoctor();
                        dt.setTerm3(false);
                        doctorTermsService.save(dt);
                        date = dt.getDate();
                        break;
                    } else if (dt.isTerm4()) {
                        doctor = dt.getDoctor();
                        dt.setTerm4(false);
                        doctorTermsService.save(dt);
                        date = dt.getDate();
                        break;
                    } else if (dt.isTerm5()) {
                        doctor = dt.getDoctor();
                        dt.setTerm5(false);
                        doctorTermsService.save(dt);
                        date = dt.getDate();
                        break;
                    } else if (dt.isTerm6()) {
                        doctor = dt.getDoctor();
                        dt.setTerm6(false);
                        doctorTermsService.save(dt);
                        date = dt.getDate();
                        break;
                    }
                }

            }

            rts = roomTermsServie.findByDate(date);

            for (RoomTerms rr : rts) {
                if (rr.isTerm1()) {
                    rr.setTerm1(false);
                    room = rr.getRoom();
                    roomTermsServie.save(rr);
                    break;
                } else if (rr.isTerm2()) {
                    rr.setTerm2(false);
                    room = rr.getRoom();
                    roomTermsServie.save(rr);
                    break;
                } else if (rr.isTerm3()) {
                    rr.setTerm3(false);
                    room = rr.getRoom();
                    roomTermsServie.save(rr);
                    break;
                } else if (rr.isTerm4()) {
                    rr.setTerm4(false);
                    room = rr.getRoom();
                    roomTermsServie.save(rr);
                    break;
                } else if (rr.isTerm5()) {
                    rr.setTerm5(false);
                    room = rr.getRoom();
                    roomTermsServie.save(rr);
                    break;
                } else if (rr.isTerm6()) {
                    rr.setTerm6(false);
                    room = rr.getRoom();
                    roomTermsServie.save(rr);
                    break;
                }


            }

            ct.setType(rq.getType());
            ct.setRoom(room);
            ct.setRequestForConsult(rq);
            Patient p = patientService.findById(rq.getPatient().getId());
            ct.setPatient(p);
            ct.setDate(date);
            ct.setPrice((double) 0);
            ct.setDuration((double) 2);
            ct.setDiscount((double) 0);

            ct.setDoctor(doctor);
            ct.setClinic(clinicsService.findOne(doctor.getClinic().getId()));
            ct = consultTermService.save(ct);

            smtpMailSender.send(ct.getPatient().getEmail(),"Consult term",
                    " You have a new consult term : "+ct.getDate());
            smtpMailSender.send(ct.getDoctor().getEmail(),"Consult term",
                    " You have a new consult term : "+ct.getDate());

        }

    }

    public ConsultTerm createConsultTerm(ConsultTermDTO consultTermDTO){
        ConsultTerm ct = new ConsultTerm();

        ct.setType(consultTypeService.findOne(consultTermDTO.getType().getId()));
        ct.setDuration(consultTermDTO.getDuration());
        ct.setDiscount(consultTermDTO.getDiscount());
        ct.setPrice(consultTermDTO.getPrice());
        ct.setDate(consultTermDTO.getDate());
        Doctor d = doctorService.findByName(consultTermDTO.getDoctor().getName());
        ct.setDoctor(d);
        ct.setClinic(d.getClinic());
        Room r = roomService.findByName(consultTermDTO.getRoom().getName());
        ct.setRoom(r);
        ct.setPatient(new Patient());
        ct = this.save(ct);

        return  ct;
    }

    public List<ConsultTermDTO> getDoctorsByTypeId(String typeName) {

        List<ConsultTerm> term = this.findByTypeName(typeName);
        List<ConsultTermDTO> termsDTO = new ArrayList<>();
        for (ConsultTerm ct : term) {
            termsDTO.add(new ConsultTermDTO(ct));
        }
        return termsDTO;
    }

    public List<ConsultTermDTO> getAllConsultTermsUserID(Long userId) {

        List<ConsultTerm> cts = this.findAll();
        List<ConsultTermDTO> ctDTO = new ArrayList<>();
        for (ConsultTerm ct : cts) {
            if(ct.getPatient().getId() == userId)
                ctDTO.add(new ConsultTermDTO(ct));
        }
        return ctDTO;
    }
}

