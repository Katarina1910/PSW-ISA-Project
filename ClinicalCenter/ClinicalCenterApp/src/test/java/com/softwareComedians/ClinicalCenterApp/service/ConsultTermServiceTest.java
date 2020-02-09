package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.ConsultTermDTO;
import com.softwareComedians.ClinicalCenterApp.mail.SmtpMailSender;
import com.softwareComedians.ClinicalCenterApp.model.*;
import com.softwareComedians.ClinicalCenterApp.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConsultTermServiceTest {

    @Autowired
    private ConsultTermService consultTermService;

    @Autowired
    private ConsultTypeService consultTypeService;

    @Autowired
    private RequestForConsultService requestForConsultService;

    @Autowired
    private SmtpMailSender smtpMailSender;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private  RoomTermsServie roomTermsServie;

    @Autowired
    private DoctorTermsService doctorTermsService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private  DoctorService doctorService;

    @Autowired
    private  ClinicsService clinicsService;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void findAll() {
        List<ConsultTerm> consultTerms = (List<ConsultTerm>) consultTermService.findAll();
        assertEquals(consultTerms.size(), 4);
    }

    @Test
    public void findById() {
        ConsultTerm consultTerm = consultTermService.findById(1L);

        assertEquals(consultTerm.getDate() ,"2019-12-31 00:00:00");
        assertEquals(consultTerm.getDiscount(), 5);
        assertEquals(consultTerm.getDuration(), 10);
        assertEquals(consultTerm.getPrice(), 150);
        assertEquals(consultTerm.getClinic().getId(), 1L);
        assertEquals(consultTerm.getDoctor().getId(), 4);
        assertEquals(consultTerm.getPatient().getId(), 2L);
        assertEquals(consultTerm.getRoom().getId(), 2L);
        assertEquals(consultTerm.getType().getId(), 1);

    }

    @Test
    @Transactional
    @Rollback(true)
    public void reserveRoom() {

        ConsultTerm ct= new ConsultTerm();
        RequestForConsult rq = requestForConsultService.findById(1L);
        ConsultTermDTO consultTermDTO = new ConsultTermDTO();
        int dbSizeBeforeAdd = consultTermService.findAll().size();

        List<RoomTerms> rts= roomTermsServie.findByDate("2020-02-04");
        List<DoctorTerms> dts = doctorTermsService.findByDate("2020-02-04");

        Room room = roomService.findByName("room1");
        Doctor doctor  = doctorService.findOne(5L);


        DoctorTerms dt = null;
        RoomTerms r = null;
        for (RoomTerms rr : rts){
            if(rr.getRoom().getName().equals(room.getName())){
                r=rr;
            }
        }

        for(DoctorTerms d : dts){
            if(d.getDoctor().getId() == doctor.getId()){
                dt = d;
            }
        }

        String term = "09:00-11:00";
        r.setTerm2(false);
        dt.setTerm2(false);

        RoomTerms roomTerms =  roomTermsServie.save(r);
        DoctorTerms doctorTerms = doctorTermsService.save(dt);

        ct.setType(rq.getType());
        ct.setRoom(room);
        ct.setRequestForConsult(rq);
        ct.setPatient((Patient) rq.getPatient());
        ct.setDate("2020-02-04");
        ct.setPrice((double) 0);
        ct.setDuration((double) 2);
        ct.setDiscount((double) 0);
        ct.setDoctor(doctor);
        ct.setClinic(clinicsService.findOne(doctor.getClinic().getId()));

        ct = consultTermService.save(ct);

        ConsultTerm testCT = null;

        try {
            testCT = consultTermService.reserveRoom("2020-02-04","09:00-11:00","room1",5L,1L);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<ConsultTerm> consultTermList = consultTermService.findAll();
       // assertEquals(consultTermList.size(), dbSizeBeforeAdd+1);

        testCT = consultTermList.get(consultTermList.size()-1);
        assertEquals(testCT.getDoctor().getId(), 5L);
        assertEquals(testCT.getRoom().getName(),"room1");
        assertEquals(testCT.getDate(),"2020-02-04");
        assertEquals(doctorTerms.isTerm2(), false);
        assertEquals(roomTerms.isTerm2(), false);
    }
}
