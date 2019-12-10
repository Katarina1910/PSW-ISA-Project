import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { PatientProfileSettingsComponent } from './patientProfileSettings.component';

describe('ProfileSettingsComponent', () => {
  let component: PatientProfileSettingsComponent;
  let fixture: ComponentFixture<PatientProfileSettingsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatientProfileSettingsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientProfileSettingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
