import { Component, OnInit } from '@angular/core';
import { listOfClinicsPatService } from './listOfClinicsPat.service';
import { listOfClinicsPat } from './listOfClinicsPat';
import { DeleteConsultTypeService } from '../consultType/deleteConsultType.service';
import { ConsultType } from '../consultType/consultType';
import { ConsultTerm } from '../consultTerm/consultTerm';
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

@Component({
    selector: 'pat-listOfClinics',
    templateUrl: './listOfClinicsPat.component.html',
    styleUrls: ['./listOfClinicsPat.component.css']
})

export class ListOfPatClinics implements OnInit{

    public listClin : listOfClinicsPat[];
    public pListClin: listOfClinicsPat[] = [];
    public types: ConsultType[];
    public _clinicAddress: string;
    public _doctorName: string;
    public _doctorSurname: string;
    public _doctorGrade: any;
    public filteredClinics: listOfClinicsPat[];
    public selectedType: ConsultType;
    public selectedType2: ConsultType;
    public filteredDoctors: Doctor[];
    public filteredDoctorsClinic: Doctor[];
    public _clinicRating: any;
    public selectedDate: Date;
    public selectedDate2: Date;
    public sortedClinics: listOfClinicsPat[];
    public sortedDoctorsClinics: listOfClinicsPat[];
    
    public sortedDoctors: Doctor[];
    private seeDoctors: boolean;
    private seeClinicsDoctors: boolean;
    public selectedClinic: Clinic;
    public doctors: Doctor[] = [];
    public doctors2: Doctor[] = [];
    public doctors3: Doctor[] = [];
    public doctorsClinic: Doctor[] = [];
    public seeDoctorsList: Doctor[] = [];
    public seeDoctorsList2: Doctor[] = [];

    public appointedExamination: appointedExamination;
    public user: User;

    public consultTerms: ConsultTerm[];
    consultTermModel = new ConsultTerm(null,null,null,null,null,null,null,null,null,null,null);

    constructor(private _listOfClinicsService: listOfClinicsPatService, 
                private _getConsultTypes: DeleteConsultTypeService,
                private _getAllDoctors: DeleteDoctorService,
                private _requestExaminationService: requestExamination,
                private _loginService: UserService,
                private _consultTermService: ConsultTermService) {
        
        this.selectedType = new ConsultType(null,null,null);
        this.appointedExamination = new appointedExamination();
    }

    ngOnInit(){
        this._listOfClinicsService.getListOfClinics().subscribe(
            data=>{
                this.listClin = data;
                this.filteredClinics = data;
            },
            error=>console.error('Error list of clinics!',error)
        )
        this._getConsultTypes.getConsultTypes().subscribe(
            data=>this.types = data,
            error=> console.error('Error consult types!', error)
        )
        this._getAllDoctors.getDoctors().subscribe(
            data=>{
                this.doctors = data;
            },
            error=> console.error('Error doctors!', error)
        );

        this._loginService.getUserInfo().subscribe({next: user=>{
            this.user=user;
            console.log(user);}
        })

        this._consultTermService.getConsultTermsInfo().subscribe(
            data=> {
                this.consultTerms = data;
            }, error => {
                console.log("Error in getting consult term data!")
        });
    }

    schedule(doc: Doctor) {
        for(let ct of this.consultTerms) {
            if(ct.doctor.id == doc.id) {
                this.consultTermModel.id = +doc.id;
            }
        }
        this.consultTermModel.id = 1;
        this.consultTermModel.doctor = doc;
        this.consultTermModel.date = this.selectedDate;
        for(let t of this.types) {
            if(t.id == doc.typeId) {
                this.consultTermModel.type = t;
            }
        }
        this.consultTermModel.patient = this.user;
        this._requestExaminationService.appointExamination(this.consultTermModel, this.user.id).subscribe(
            data=> {
                console.log('Success!', JSON.stringify(data));
            }, error => {
                console.log("Error in appointing examination");
            }
        )
        console.log(this.consultTermModel);
        alert("Examination has been scheduled!")
    }

    get clinicAddress():string{
        return this._clinicAddress;
    }

    set clinicAddress(value:string){
        this._clinicAddress=value;
        this.filteredClinics = this.clinicAddress ? this.filter(this.clinicAddress):this.listClin;
    }

    get clinicRating():string{
        return this._clinicRating;
    }

    set clinicRating(value:string){
        this._clinicRating=value;
        this.filteredClinics = this.clinicRating ? this.filter2(this.clinicRating):this.listClin;
    }

    filter(filterField:string):listOfClinicsPat[]{
        filterField = filterField.toLocaleLowerCase();
        return this.listClin.filter((clinic:listOfClinicsPat)=>clinic.address.toLowerCase().indexOf(filterField)!=-1);
    }

    filter2(filterField:string):listOfClinicsPat[]{
        filterField = filterField.toLocaleLowerCase();
        return this.listClin.filter((clinic:listOfClinicsPat)=>clinic.grade.toString().indexOf(filterField)!=-1);
    }

    //filtriranje za doktora po imenu, prezimenu i oceni
    get doctorName():string{
        return this._doctorName;
    }

    set doctorName(value:string){
        this._doctorName=value;
        this.filteredDoctors = this.doctorName ? this.filterDoctorName(this.doctorName):this.doctors;
    }

    filterDoctorName(filterField:string):Doctor[]{
        filterField = filterField.toLocaleLowerCase();
        return this.doctors.filter((doctor:Doctor)=>doctor.name.toLowerCase().indexOf(filterField)!=-1);
    }

    get doctorSurname():string{
        return this._doctorSurname;
    }

    set doctorSurname(value:string){
        this._doctorSurname=value;
        this.filteredDoctors = this.doctorSurname ? this.filterDoctorSurname(this.doctorSurname):this.doctors;
    }

    filterDoctorSurname(filterField:string):Doctor[]{
        filterField = filterField.toLocaleLowerCase();
        return this.doctors.filter((doctor:Doctor)=>doctor.surname.toLowerCase().indexOf(filterField)!=-1);
    }


    get doctorGrade():string{
        return this._doctorGrade;
    }

    set doctorGrade(value:string){
        this._doctorGrade=value;
        this.filteredDoctors = this.doctorGrade ? this.filterDoctorGrade(this.doctorGrade):this.doctors;
    }

    filterDoctorGrade(filterField:string):Doctor[]{
        filterField = filterField.toLocaleLowerCase();
        return this.doctors.filter((doctor:Doctor)=>doctor.grade.toString().indexOf(filterField)!=-1);
    }

    buttonSearch(): void{
        const formatedDate = moment(this.selectedDate).format('YYYY-MM-DD');
        const selectedType2 = this.selectedType;
        this.listClin = [];
        this.seeDoctorsList = [];
        this._getAllDoctors.getDoctors().subscribe(
            data=> {
                this.doctors2 = data;
                for(let doc of this.doctors2) {
                    const formatedDateFrom = moment(doc.scheduledFrom).format('YYYY-MM-DD');
                    const formatedDateTo = moment(doc.scheduledTo).format('YYYY-MM-DD');
                    if(formatedDate <= formatedDateTo && formatedDate >= formatedDateFrom) {

                    } else {
                        if(selectedType2.id == doc.typeId) {
                            console.log(doc);
                            this.seeDoctorsList.push(doc);
                            //TODO: uzeti sve klinike koje imaju ove doktore
                            this._listOfClinicsService.getListOfClinics().subscribe(
                                data=>{
                                    this.pListClin = data;
                                    for(let clin of this.pListClin) {
                                        if(clin.id == doc.clinic) {
                                            this.listClin.push(clin);
                                        }
                                    }
                                },
                                error=>console.error('Error list of clinics!',error)
                            )
                        }
                    }
                }
            }, error => {
                console.log("Error in getting doctors!");
            }
        )
        this.seeDoctors = false;
        this.seeClinicsDoctors = false;
    }

    listOfDoctors(clinic: Clinic): void {
        this.selectedClinic = clinic;
        this.doctors = [];
        if(this.selectedType.id != null) {
            this.seeDoctors = true;
            for(let doc of this.seeDoctorsList) {
                if(this.selectedClinic.id == doc.clinic && this.selectedType.id == doc.typeId) {
                    this.doctors.push(doc);
                }
            }
        } else {
            alert("Type or date is not selected!");
        }
    }

    listOfClinicsDoctors(clinic: Clinic): void {
        this.selectedClinic = clinic;
        this.seeClinicsDoctors = true;
        this.doctorsClinic = [];
        this.doctors3 = [];
        this._getAllDoctors.getDoctors().subscribe(
            data => {
                this.doctors2 = data;
                for(let doc of this.doctors2) {
                    if(this.selectedClinic.id == doc.clinic) {
                        this.doctorsClinic.push(doc);
                        this.doctors3.push(doc);
                    }
                }
            }
        )
        this.doctors2=[];
    }

    buttonSearch2(): void {
        const formatedDate = moment(this.selectedDate2).format('YYYY-MM-DD');
        const selectedTypePom = this.selectedType2;
        this.doctorsClinic = [];
        
        for(let doc of this.doctors3){
            const formatedDateFrom = moment(doc.scheduledFrom).format('YYYY-MM-DD');
            const formatedDateTo = moment(doc.scheduledTo).format('YYYY-MM-DD');
            if(formatedDate <= formatedDateTo && formatedDate >= formatedDateFrom) {
            } else {
                if(selectedTypePom.id == doc.typeId) {
                    console.log(doc);
                    this.doctorsClinic.push(doc);      
                }
            }
        }
        //this.doctors3 = [];
    }

    sortData(sort: Sort) {
        const data = this.listClin;
        if (!sort.active || sort.direction === '') {
          this.sortedClinics = data;
          return;
        }
    
        this.sortedClinics = data.sort((a, b) => {
          const isAsc = sort.direction === 'asc';
          switch (sort.active) {
            case 'name': return compare(a.name, b.name, isAsc);
            case 'address': return compare(a.address, b.address, isAsc);
            case 'description': return compare(a.description, b.description, isAsc);
            case 'grade': return compare(a.grade, b.grade, isAsc);
            default: return 0;
          }
        });
    }

    sortData2(sort: Sort) {
        const data = this.doctors;
        if (!sort.active || sort.direction === '') {
          this.sortedDoctors = data;
          return;
        }
    
        this.sortedDoctors = data.sort((a, b) => {
          const isAsc = sort.direction === 'asc';
          switch (sort.active) {
            case 'name': return compare(a.name, b.name, isAsc);
            case 'surname': return compare(a.surname, b.surname, isAsc);
            case 'grade': return compare(a.grade, b.grade, isAsc);
            default: return 0;
          }
        });
    }
    
    hideAllDoctors(): void{
        this.seeDoctors = false;
    }

    //filtriranje za doktora po imenu, prezimenu i oceni
    get doctorName2():string{
        return this._doctorName;
    }

    set doctorName2(value:string){
        this._doctorName=value;
        this.filteredDoctorsClinic = this.doctorName2 ? this.filterDoctorName2(this.doctorName2):this.doctorsClinic;
    }

    filterDoctorName2(filterField:string):Doctor[]{
        filterField = filterField.toLocaleLowerCase();
        return this.doctorsClinic.filter((doctor:Doctor)=>doctor.name.toLowerCase().indexOf(filterField)!=-1);
    }

    get doctorSurname2():string{
        return this._doctorSurname;
    }

    set doctorSurname2(value:string){
        this._doctorSurname=value;
        this.filteredDoctorsClinic = this.doctorSurname2 ? this.filterDoctorSurname2(this.doctorSurname2):this.doctorsClinic;
    }

    filterDoctorSurname2(filterField:string):Doctor[]{
        filterField = filterField.toLocaleLowerCase();
        return this.doctorsClinic.filter((doctor:Doctor)=>doctor.surname.toLowerCase().indexOf(filterField)!=-1);
    }


    get doctorGrade2():string{
        return this._doctorGrade;
    }

    set doctorGrade2(value:string){
        this._doctorGrade=value;
        this.filteredDoctorsClinic = this.doctorGrade2 ? this.filterDoctorGrade2(this.doctorGrade2):this.doctorsClinic;
    }

    filterDoctorGrade2(filterField:string):Doctor[]{
        filterField = filterField.toLocaleLowerCase();
        return this.doctorsClinic.filter((doctor:Doctor)=>doctor.grade.toString().indexOf(filterField)!=-1);
    }

}

function compare(a: number | string, b: number | string, isAsc: boolean) {
    return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}