import { Component, OnInit } from '@angular/core';
import { User } from '../registration/user';
import { Router } from '@angular/router';
import { MedicalRecordd } from './medicalRecord';
import { MedicalRecordService } from './medicalRecord.service';
import { listOfPatientsService } from '../doctorHomePage/listOfPatients.service';
import { PatientProfileDocService } from '../patientProfileDoc/patientProfileDoc.service';
import { Consult } from '../ConsultTermReport/Consult';
import { listOfDiagnosisService } from '../listOfAllDiagnosis/listOfAllDiagnosis.service';
import { listOfDiagnosis } from '../listOfAllDiagnosis/listOfAllDiagnosis';

@Component({
    selector: 'med-rec',
    templateUrl: './medicalRecord.component.html'
})

export class MedicalRecord implements OnInit{

    private view : string = "VIEW";
    public selectedDiagnosis :{};
    public listDiag : [];
    public report: string;
    public diagnosisSettings : {};
    user: User = new User("","","","","","","","","","","","","",false);
    medicalRecord = new MedicalRecordd(null, '','','','','','');
    public consults: Consult[];
    id: string;
    public idConsult: string;
    public consult= new Consult(null,null,null,null,null,null);

    constructor(private router: Router, private medicalRecordService: MedicalRecordService,
      private patientProfileDoc: PatientProfileDocService,
       private _listOfDiagnosisService: listOfDiagnosisService  ) { 
    }

  ngOnInit(): void {
    this.id = localStorage.getItem("user-id");
    this.getProfile();

    this.diagnosisSettings = {
      singleSelection: true,
      idField: 'id',
      textField: 'name',
      allowSearchFilter: true
    };

    this._listOfDiagnosisService.getListOfDiagnosis().subscribe(
      data=>{
          this.listDiag = data;
      },
      error=>console.error('Error!',error)
     )

    this.medicalRecordService.getMedicalRecord()
     .subscribe(
         data => {
            console.log('Success!', JSON.stringify(data))
            this.medicalRecord = data;
         },
         error => console.error('Error!',error)
     );

     this.medicalRecordService.getConsults().subscribe(
      data=>{
              this.consults = data;
      },error=>{

      }
    );
  } 

  refresh(): void{
    this.medicalRecordService.getMedicalRecord()
     .subscribe(
         data => {
            console.log('Success!', JSON.stringify(data))
            this.medicalRecord = data;
            //this.router.navigate(['/HomepageDoctor/ListOfPatients/Profile/MedicalRecord']);
         },
         error => console.error('Error!',error)
     );

     this.medicalRecordService.getConsults().subscribe(
      data=>{
              this.consults = data;
      },error=>{

      }
    );
  }

  getProfile(): void{
    this.user = this.medicalRecordService.user;
 }

change(c: Consult): void{
    this.selectedDiagnosis = c.diagnosis;
    this.report = c.report;
    this.idConsult = c.id;
    this.view = "EDIT";

}

 Edit():void{
   this.medicalRecordService.editMedicalRecord(this.medicalRecord).subscribe(
      data =>{
            alert('Medical record successufully edited');
            this.router.navigate(['/HomepageDoctor/ListOfPatients/Profile']);
      },
      error =>{
        alert("Medical record has not been edited");
      }
   )
  
 }

 editConsult(): void{
       this.view = "VIEW";
       this.consult.diagnosis = new listOfDiagnosis(this.selectedDiagnosis[0].id,null,null,null);
       this.consult.id = this.idConsult;
       this.consult.report = this.report;

       this.medicalRecordService.editConsults(this.consult).subscribe(
          data=>{
              alert("Successufully edited");
              this.refresh();
          },error =>{
            alert("Error saving");
          }

       );

       this.report = "";
       this.selectedDiagnosis =null;
       this.idConsult = "";
 }
}
