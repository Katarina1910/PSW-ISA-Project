import { Component, OnInit } from '@angular/core';
import { listOfClinicsPatService } from './listOfClinicsPat.service';
import { listOfClinicsPat } from './listOfClinicsPat';
import { DeleteConsultTypeService } from '../consultType/deleteConsultType.service';
import { ConsultType } from '../consultType/consultType';
import { ConsultTerm } from '../consultTerm/consultTerm';
import { ConsultTermService } from '../consultTerm/consultTerm.service';
import * as moment from 'moment';
import {Sort} from '@angular/material/sort';
import { DeleteDoctorService } from '../doctor/deleteDoctor.service';
import { Clinic } from '../addNewClinic/clinic';
import { Doctor } from '../doctor/doctor';

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
    public filteredDoctors: Doctor[];
    public _clinicRating: any;
    public selectedDate: Date;
    public consultTerms: ConsultTerm[];
    public consultTerms2: ConsultTerm[];

    public sortedClinics: listOfClinicsPat[];
    
    public sortedDoctors: Doctor[];
    private seeDoctors: boolean;
    public selectedClinic: Clinic;
    public doctors: Doctor[] = [];
    public doctors2: Doctor[] = [];

    constructor(private _listOfClinicsService: listOfClinicsPatService, 
                private _getConsultTypes: DeleteConsultTypeService,
                private _consultTermService: ConsultTermService,
                private _getAllDoctors: DeleteDoctorService) {
        
        this.selectedType = new ConsultType(null,null,null);
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
    }

    buttonSearch(): void{
        const formatedDate = moment(this.selectedDate).format('YYYY-MM-DD')

        this._consultTermService.getConsultTermsInfo().subscribe(
            data=> {
                this.consultTerms = data;
                this.consultTerms.forEach(function (value){
                    const formatedDate2 = moment(value.date).format('YYYY-MM-DD')
                    if(formatedDate == formatedDate2) {
                        console.log("Datumi su isti");
                    } else {
                        console.log("Datumi nisu isti");
                    }
                });
            }, error => {
                console.log("Error in getting consult term data!")
            });

        console.log('ime tipa je: ', this.selectedType.name);
    }

    listOfDoctors(clinic: Clinic): void {
        this.selectedClinic = clinic;
        this.doctors = [];
        if(this.selectedType.id != null) {
            this.seeDoctors = true;
            this._consultTermService.getConsultTermsInfo().subscribe(
                data=> {
                    this.consultTerms2 = data;
                    for(let ct of this.consultTerms2) {
                        if(JSON.stringify(ct.type) == JSON.stringify(this.selectedType.name)) {
                            this._getAllDoctors.getDoctors().subscribe(
                                data=> {
                                    this.doctors2 = data;
                                    for(let d of this.doctors2) {
                                        if(JSON.stringify(this.selectedType.id) == JSON.stringify(d.typeId)) {
                                            this.doctors.push(d);
                                        } else {
                                            console.log("Izabrani tip pregleda se ne poklapa sa tipom iz baze")
                                        }
                                    }
                                })
                        break;  //da ne bi vise puta iste lekare ispisivao
                        } else {
                            console.log("Imena tipova pregleda nisu jednaka")
                        }
                    }
                }, error => {
                    console.log("Error in getting consult term2 data!")
                });
                
        } else {
            alert("Type or date is not selected!");
        }
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

}

function compare(a: number | string, b: number | string, isAsc: boolean) {
    return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}