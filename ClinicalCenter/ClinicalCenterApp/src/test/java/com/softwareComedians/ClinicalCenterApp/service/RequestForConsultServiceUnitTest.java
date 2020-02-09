package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.RequestForConsultDTO;
import com.softwareComedians.ClinicalCenterApp.dto.UserDTO;
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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequestForConsultServiceUnitTest {

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

    @Autowired
    private  ConsultTypeService consultTypeService;

    @MockBean
    private  DoctorRepository doctorRepositoryMocked;

    @MockBean
    private  ClinicsRepository clinicsRepositoryMocked;

    @MockBean
    private  PatientRepository patientRepositoryMocked;

    @MockBean
    private  ConsultTypeRepository consultTypeRepositoryMocked;

    @MockBean
    private  UserRepository userRepositoryMocked;


    @MockBean
    private  ClinicAdminRepository clinicAdminRepositoryMocked;

    @Autowired
    private UserService userService;




    @Autowired
    private PatientService patientService;

    @Before
    public void setUp() throws ParseException {
        MockitoAnnotations.initMocks(this);

        ConsultType type = new ConsultType(); type.setId(1L);
        RequestForConsult requestForConsult = new RequestForConsult();
        requestForConsult.setId(1L);
        requestForConsult.setAccepted(false);
        requestForConsult.setDateAndTime("2020-02-05");
        requestForConsult.setType(type);
        User user = new User(); user.setId(1L);
        requestForConsult.setPatient(user);

        ClinicAdministrator clinicAdministrator = new ClinicAdministrator();
        clinicAdministrator.setId(1L);
        clinicAdministrator.setEmail("katarinaprodanovic97@gmail.com");

        Clinic clinic = new Clinic();
        clinic.setId(1L);

        Set<ClinicAdministrator> clinicAdmin = new HashSet<>();
        clinicAdmin.add(clinicAdministrator);
        

        ConsultTerm ct = new ConsultTerm(); ct.setId(1L);

        Mockito.when(consultTypeRepositoryMocked.findById(type.getId())).thenReturn(Optional.of(type));
        Mockito.when(requestForConsultRepositoryMocked.findById(requestForConsult.getId())).thenReturn(Optional.of(requestForConsult));
        Mockito.when(userRepositoryMocked.findById(user.getId())).thenReturn(Optional.of(user));
        Mockito.when(consultTermRepositoryMocked.findById(ct.getId())).thenReturn(Optional.of(ct));
        Mockito.when(clinicsRepositoryMocked.findById(ct.getId())).thenReturn(Optional.of(clinic));

    }


    @Test
    @Transactional
    @Rollback(true)
    public void create() throws MessagingException {

        RequestForConsult rq = requestForConsultService.findById(1L);
        RequestForConsultDTO rqDto = new RequestForConsultDTO(rq);

        User patient = userService.findById(1L);
        UserDTO userDTO = new UserDTO(patient);


        Mockito.when(requestForConsultRepositoryMocked.findById(rq.getId())).thenReturn(Optional.of(rq));
        Mockito.when(requestForConsultRepositoryMocked.save(any(RequestForConsult.class))).thenReturn(rq);

        RequestForConsult  req = requestForConsultService.createReq(rqDto,1L);

        assertEquals(rq.getId(), req.getId());
    }

    @Test(expected = ApiRequestException.class)
    public void whenToCreate_requestNotFound() throws MessagingException {
        final Long rqId = 100L;
        RequestForConsult rq = requestForConsultService.findById(rqId);
        RequestForConsultDTO requestForConsultDTO = new RequestForConsultDTO(rq);
        Mockito.when(requestForConsultRepositoryMocked.findById(rqId)).thenReturn(Optional.empty());
        requestForConsultService.createReq(requestForConsultDTO,1L);
    }

}
