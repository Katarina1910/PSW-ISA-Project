import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { PatientProfilePageComponent } from './patientProfilePage.component';


describe('ProfilePageComponent', () => {
  let component: PatientProfilePageComponent;
  let fixture: ComponentFixture<PatientProfilePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatientProfilePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientProfilePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
