package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.exception.ApiRequestException;
import com.softwareComedians.ClinicalCenterApp.model.*;
import com.softwareComedians.ClinicalCenterApp.repository.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConsultTermServiceUnitTest {

    @Autowired
    ConsultTermService  consultTermService;

    @MockBean
    ConsultTermRepository consultTermRepositoryMocked;

    @MockBean
    RequestForConsultRepository requestForConsultRepositoryMocked;

    @Autowired
    RequestForConsultService requestForConsultService;

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

    @MockBean
    private DoctorTermsRepository doctorTermsRepositoryMocked;

    @MockBean
    private RoomTermRepository roomTermRepositoryMocked;

    @MockBean
    private RoomRepository roomRepositoryMocked;

    @MockBean
    private  DoctorRepository doctorRepositoryMocked;

    @MockBean
    private  ClinicsRepository clinicsRepositoryMocked;

    @MockBean
    private  PatientRepository patientRepositoryMocked;

    @Autowired
    private UserService userService;

    @Autowired
    private PatientService patientService;

    @Before
    public void setUp() throws ParseException {
        MockitoAnnotations.initMocks(this);

        ConsultTerm consultTerm = new ConsultTerm();
        consultTerm.setId(1L);
        RequestForConsult rq = new RequestForConsult(); rq.setId(1L);
        String term = "09:00-11:00";
        ConsultType consultType = new ConsultType();
        consultType.setId(1L);
        rq.setType(consultType);
        User patient = new User(); patient.setId(2L);
        Patient patient1 = new Patient(); patient1.setId(2L);
        Clinic clinic = new Clinic(); clinic.setId(1L);
        rq.setPatient(patient);
        ArrayList<ConsultTerm>  consultTerms = new ArrayList<>();
        ConsultTerm c1 = new ConsultTerm(); c1.setId(2L);
        ConsultTerm c2 = new ConsultTerm(); c2.setId(3L);
        ConsultTerm c3 = new ConsultTerm(); c3.setId(4L);
        consultTerms.add(c1);
        consultTerms.add(c2);
        consultTerms.add(c3);
        Room room = new Room(); room.setId(1L); room.setName("room1");
        Room room2 = new Room(); room2.setId(2L); room2.setName("room2");

        RoomTerms rt1 = new RoomTerms(); rt1.setId(1L); rt1.setDate("2020-02-04");
        RoomTerms rt2 = new RoomTerms(); rt2.setId(2L); rt2.setDate("2020-02-04");
        rt1.setRoom(room); rt2.setRoom(room2);

        List<RoomTerms> roomTerms = new ArrayList<>();
        roomTerms.add(rt1);
        roomTerms.add(rt2);
        DoctorTerms dt1 = new DoctorTerms(); rt1.setId(1L); rt1.setDate("2020-02-04");
        DoctorTerms dt2 = new DoctorTerms(); rt2.setId(2L); rt2.setDate("2020-02-04");
        List<DoctorTerms> doctorTerms = new ArrayList<>();
        doctorTerms.add(dt1);
        doctorTerms.add(dt2);

        Doctor doctor = new Doctor(); doctor.setId(5L); doctor.setClinic(clinic);
        Doctor doctor2 = new Doctor(); doctor2.setId(6L); doctor2.setClinic(clinic);
        dt1.setDoctor(doctor); dt2.setDoctor(doctor2);



        Mockito.when(consultTermRepositoryMocked.findById(consultTerm.getId())).thenReturn(Optional.of(consultTerm));
        Mockito.when(requestForConsultRepositoryMocked.findById(rq.getId())).thenReturn(Optional.of(rq));
        Mockito.when(consultTermRepositoryMocked.findAll()).thenReturn(new ArrayList<>(consultTerms));
        Mockito.when(roomTermRepositoryMocked.findByDate("2020-02-04")).thenReturn(new ArrayList<>(roomTerms));
        Mockito.when(doctorTermsRepositoryMocked.findByDate("2020-02-04")).thenReturn(new ArrayList<>(doctorTerms));
        Mockito.when(roomRepositoryMocked.findById(room.getId())).thenReturn(Optional.of(room));
        Mockito.when(clinicsRepositoryMocked.findById(clinic.getId())).thenReturn(Optional.of(clinic));
        Mockito.when(doctorRepositoryMocked.findById(doctor.getId())).thenReturn(Optional.of(doctor));
        Mockito.when(patientRepositoryMocked.findById(patient1.getId())).thenReturn(Optional.of(patient1));

    }
    @Test
    public void whenValidId_thenConsultTermShouldBeFound() {
        Long id = 1L;
        ConsultTerm foundConsultTerm = consultTermService.findById(id);

        assertEquals(id, foundConsultTerm.getId());
    }

    @Test(expected = ApiRequestException.class)
    public void whenInvalidId_thenThrowEx() {
        Long id = 150L;
        ConsultTerm foundConsultTerm = consultTermService.findById(id);
    }

    @Test
    public void whenToReserveRoom() {
        ConsultTerm ct= new ConsultTerm(); ct.setId(1L);
        RequestForConsult rq = requestForConsultService.findById(1L);

        int dbSizeBeforeAdd = consultTermService.findAll().size();

        List<RoomTerms> rts= roomTermsServie.findByDate("2020-02-04");
        List<DoctorTerms> dts = doctorTermsService.findByDate("2020-02-04");

        Room room = roomService.findOne(1L);
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

        r.setTerm2(false);
        dt.setTerm2(false);

        RoomTerms roomTerms =  roomTermsServie.save(r);
        DoctorTerms doctorTerms = doctorTermsService.save(dt);
        Mockito.when(roomTermRepositoryMocked.findById(r.getId())).thenReturn(Optional.of(r));
        assertFalse(r.isTerm2());
        Mockito.when(doctorTermsRepositoryMocked.findById(dt.getId())).thenReturn(Optional.of(dt));
        assertFalse(dt.isTerm2());

        ct.setType(rq.getType());
        ct.setRoom(room);
        ct.setRequestForConsult(rq);
        ct.setPatient(patientService.findById(2L));
        ct.setDate("2020-02-04");
        ct.setPrice((double) 0);
        ct.setDuration((double) 2);
        ct.setDiscount((double) 0);
        ct.setDoctor(doctor);
        ct.setClinic(clinicsService.findOne(doctor.getClinic().getId()));

        Mockito.when(consultTermRepositoryMocked.findById(ct.getId())).thenReturn(Optional.of(ct));
        Mockito.when(consultTermRepositoryMocked.save(any(ConsultTerm.class))).thenReturn(ct);

        ConsultTerm consultTerm1 = consultTermService.reserveRoom("2020-02-04","09:00-11:00","room1",5L,1L);
        assertEquals(ct.getId(), consultTerm1.getId());
        assertEquals(ct.getDate(), consultTerm1.getDate());
        assertEquals(ct.getDoctor().getId(), consultTerm1.getDoctor().getId());
        assertEquals(ct.getClinic().getId(), consultTerm1.getClinic().getId());

    }

    @Test(expected = ApiRequestException.class)
    public void whenToReserveRoom_requestNotFound() {
        final Long rqId = 100L;
        requestForConsultService.findById(100L);
    }
}
