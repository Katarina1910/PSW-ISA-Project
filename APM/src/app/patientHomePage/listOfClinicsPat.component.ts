import { Component, OnInit } from '@angular/core';
import { listOfClinicsPatService } from './listOfClinicsPat.service';
import { listOfClinicsPat } from './listOfClinicsPat';
import { DeleteConsultTypeService } from '../consultType/deleteConsultType.service';
import { ConsultType } from 'src/consultType/consultType';
import { ConsultTerm } from '../consultTerm/consultTerm';
import { ConsultTermService } from '../consultTerm/consultTerm.service';
import * as moment from 'moment';
import {Sort} from '@angular/material/sort';

@Component({
    selector: 'pat-listOfClinics',
    templateUrl: './listOfClinicsPat.component.html',
    styleUrls: ['./listOfClinicsPat.component.css']
})

export class ListOfPatClinics implements OnInit{

    public listClin : listOfClinicsPat[];
    public pListClin: listOfClinicsPat[] = [];
    public types: ConsultType[];
    public _clinicAdress: string;
    public filteredClinics: listOfClinicsPat[];
    public selectedType: ConsultType;
    public _clinicRating: any;
    public selectedDate: Date;
    public consultTerms: ConsultTerm[];

    public sortedClinics: listOfClinicsPat[];

    constructor(private _listOfClinicsService: listOfClinicsPatService, 
                private _getConsultTypes: DeleteConsultTypeService,
                private _consultTermService: ConsultTermService) {}

    get clinicAddress():string{
        return this._clinicAdress;
    }

    set clinicAddress(value:string){
        this._clinicAdress=value;
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

    ngOnInit(){
        this._listOfClinicsService.getListOfClinics().subscribe(
            data=>{
                this.listClin = data;
            },
            error=>console.error('Error!',error)
        )
        this._getConsultTypes.getConsultTypes().subscribe(
            data=>this.types = data,
            error=> console.error('Error!', error)
        )
        this.filteredClinics = this.listClin;
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

    }

    sortData(sort: Sort) {
        const data = this.filteredClinics;
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
    
}

function compare(a: number | string, b: number | string, isAsc: boolean) {
    return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}