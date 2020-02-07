import { async, ComponentFixture, inject, fakeAsync, TestBed } from '@angular/core/testing';
import { DebugElement } from '@angular/core';
import { By } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { of } from 'rxjs';
import { RouterTestingModule } from '@angular/router/testing';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { ListOfPatClinics } from './listOfClinicsPat.component';
import { listOfClinicsPatService } from './listOfClinicsPat.service';
import { listOfClinicsPat } from './listOfClinicsPat';
import { DeleteConsultTypeService } from '../consultType/deleteConsultType.service';
import * as moment from 'moment';
import {Sort} from '@angular/material/sort';
import { DeleteDoctorService } from '../doctor/deleteDoctor.service';
import { Clinic } from '../addNewClinic/clinic';
import { Doctor } from '../doctor/doctor';
import { appointedExamination } from './appointedExamination';
import { UserService } from '../registration/user.service';
import { User } from '../registration/user';
import { requestExamination } from '../patientRequestExamination/requestExamination.service';
import { ConsultTermService } from '../consultTerm/consultTerm.service';
import { MatDatepicker, MatDatepickerModule, MatNativeDateModule } from '@angular/material';

describe('ListOfPatClinics', () => {
    let component : ListOfPatClinics;
    let fixture: ComponentFixture<ListOfPatClinics>;
    let de: DebugElement;


    beforeEach(async(()=> {

        let _listOfClinicsServiceMock = {
            listClin: jasmine.createSpy('listClin').and.returnValue(of({
            
            })),

            pListClin: jasmine.createSpy('pListClin').and.returnValue(of({
            
            })),
      
            getListOfClinics: jasmine.createSpy('getListOfClinics').and.returnValue({ subscribe: () => {} })

          };

         
          
          let _getConsultTypesMockes = {
            types : jasmine.createSpy('types').and.returnValue(of({
            
            })),
            
            getConsultTypes: jasmine.createSpy('getConsultTypes').and.returnValue({ subscribe: () => {} })
          };


          let _getAllDoctorsMocked = {
            doctors: jasmine.createSpy('doctors').and.returnValue(of({
              
            })),

            doctors2: jasmine.createSpy('doctors2').and.returnValue(of({
              
            })),
      
            getDoctors: jasmine.createSpy('getDoctors').and.returnValue({ subscribe: () => {} })
            
          };

          let _requestExaminationServiceMocked = {
        
      
            appointExamination: jasmine.createSpy('appointExamination').and.returnValue(true)
            
          };
        
          let _loginServiceMocked = {
            user: jasmine.createSpy('user').and.returnValue(of({
              
            })),

            getUserInfo: jasmine.createSpy('getUserInfo').and.returnValue({ subscribe: () => {} })
            
          };

          let selectedDate2Mocked = {
            selectedDate2 : jasmine.createSpy('selectedDate2').and.returnValue(null),
        };
        
          let _consultTermServiceMocked = {
            consultTerms: jasmine.createSpy('consultTerms').and.returnValue(of({
              
            })),

     
            getConsultTermsInfo: jasmine.createSpy('getConsultTermsInfo').and.returnValue({ subscribe: () => {} })
            
          };
        
        

        TestBed.configureTestingModule({
            declarations : [ ListOfPatClinics ],
            schemas: [CUSTOM_ELEMENTS_SCHEMA],
            imports: [
                FormsModule,
                ReactiveFormsModule,
                RouterTestingModule,
                MatDatepickerModule, MatNativeDateModule
    
            ],
            providers: [
                { provide: listOfClinicsPatService, useValue: _listOfClinicsServiceMock },
                { provide: DeleteConsultTypeService, useValue: _getConsultTypesMockes },
                { provide : DeleteDoctorService, useValue: _getAllDoctorsMocked },
                { provide : requestExamination, useValue: _requestExaminationServiceMocked },
                { provide : UserService, useValue: _loginServiceMocked },
                { provide : ConsultTermService, useValue: _consultTermServiceMocked }
            ]
        })
        .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(ListOfPatClinics);
        component = fixture.componentInstance;
        de= fixture.debugElement;
        fixture.detectChanges();
    });

    it('should create', ()=>{
        expect(component).toBeTruthy();
    });

 
})