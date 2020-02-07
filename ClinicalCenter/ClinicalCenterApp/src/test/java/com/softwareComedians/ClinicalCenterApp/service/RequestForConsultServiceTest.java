package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.ConsultTypeDTO;
import com.softwareComedians.ClinicalCenterApp.dto.RequestForConsultDTO;
import com.softwareComedians.ClinicalCenterApp.model.ConsultType;
import com.softwareComedians.ClinicalCenterApp.model.Patient;
import com.softwareComedians.ClinicalCenterApp.model.RequestForConsult;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequestForConsultServiceTest {

    @Autowired
    private RequestForConsultService requestForConsultService;

    @Autowired
    private  ConsultTypeService consultTypeService;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void findAll() {
        List<RequestForConsult> req = (List<RequestForConsult>) requestForConsultService.findAll();
        assertEquals(req.size(), 1);
    }

    @Test
    public void findById() {
        RequestForConsult req = requestForConsultService.findById(1L);

        assertEquals(req.getDateAndTime(),"2020-02-04");
        assertEquals(req.getPatient().getId(),3);
        assertEquals(req.getType().getId(),2);
        //assertEquals(req.getConsultTerm().getId(),null);
        assertEquals(req.isAccepted(),false);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void create() {
        RequestForConsultDTO req = new RequestForConsultDTO();
        ConsultType ct = consultTypeService.findOne(1L);
        ConsultTypeDTO ctdto = new ConsultTypeDTO(ct);
        req.setId((long) 2);
        req.setAccepted(false);
        //req.setConsultTerm(null);
        req.setDateAndTime("2020-02-05");
        req.setType(ctdto);


        int dbSizeBeforeAdd = requestForConsultService.findAll().size();

        RequestForConsult dbReq = null;
        try {
            dbReq = requestForConsultService.createReq(req, (long) 2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Validate that new student is in the database
        List<RequestForConsult> reqs = requestForConsultService.findAll();
        assertEquals(reqs.size(), dbSizeBeforeAdd+1);

        dbReq = reqs.get(reqs.size() - 1); //get last student
        //assertEquals(dbReq.getId(),2L);
        assertEquals(dbReq.getDateAndTime(),"2020-02-05");
        assertEquals(dbReq.isAccepted(),false);
        assertEquals(dbReq.getType().getName(), "tip1");

    }
}
