import { async, ComponentFixture, inject, fakeAsync, TestBed } from '@angular/core/testing';
import { DebugElement } from '@angular/core';
import { By } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Room } from '../rooms/room';
import { RoomTerms } from '../rooms/roomTerms';
import { DeleteRoomService } from '../rooms/deleteRoom.servce';
import { DoctorRequestForConsult } from '../doctorRequestForConsult/doctorRequestForConsult';
import { DoctorRequestForConsultService } from '../doctorRequestForConsult/doctorRequestForConsult.service';
import { ReserveRoomService } from './reserveRooms.service';
import { DoctorTerm } from './doctorTerm';
import { ReserveRoomsComponent } from './reserveRooms.component';
import { of } from 'rxjs';
import { RouterTestingModule } from '@angular/router/testing';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

describe('ReserveRoomsComponent', () => {
    let component : ReserveRoomsComponent;
    let fixture: ComponentFixture<ReserveRoomsComponent>;
    let de: DebugElement;


    beforeEach(async(()=> {

        let _deleteRoomServiceMock = {
            rooms: jasmine.createSpy('rooms').and.returnValue(of({
            
            })),
      
            getRoomsEx: jasmine.createSpy('getRoomsEx').and.returnValue({ subscribe: () => {} })
          };

          let dateeMocked = {
              datee : jasmine.createSpy('datee').and.returnValue(null),
          };

          
          let _rqsServiceMocked = {
            rqs : jasmine.createSpy('rqs').and.returnValue(of({
            
            })),
            
            getRequests: jasmine.createSpy('getRequests').and.returnValue({ subscribe: () => {} })
          };

          let _rrServiceMocked = {
            docTerms: jasmine.createSpy('docTerms').and.returnValue(of({
              
            })),
      
            getDoctorTerms: jasmine.createSpy('getDoctorTerms').and.returnValue(false),
            reserveRoom: jasmine.createSpy('reserveRoom').and.returnValue(false)
          };
        

        TestBed.configureTestingModule({
            declarations : [ ReserveRoomsComponent ],
            schemas: [CUSTOM_ELEMENTS_SCHEMA],
            imports: [
                FormsModule,
                ReactiveFormsModule,
                RouterTestingModule,
    
            ],
            providers: [
                { provide: DeleteRoomService, useValue: _deleteRoomServiceMock },
                { provide: DoctorRequestForConsultService, useValue: _rqsServiceMocked },
                { provide : ReserveRoomService, useValue: _rrServiceMocked }
            ]
        })
        .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(ReserveRoomsComponent);
        component = fixture.componentInstance;
        de= fixture.debugElement;
        fixture.detectChanges();
    });

    it('should create', ()=>{
        expect(component).toBeTruthy();
    });

 
})