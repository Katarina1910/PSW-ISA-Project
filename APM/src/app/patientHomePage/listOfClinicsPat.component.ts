import { Component, OnInit } from '@angular/core';
import { listOfClinicsPatService } from './listOfClinicsPat.service';
import { listOfClinicsPat } from './listOfClinicsPat';
import { DeleteConsultTypeService } from '../consultType/deleteConsultType.service';
import { ConsultType } from 'src/consultType/consultType';
import { ConsultTerm } from '../consultTerm/consultTerm';
import { ConsultTermService } from '../consultTerm/consultTerm.service';


@Component({
    selector: 'pat-listOfClinics',
    templateUrl: './listOfClinicsPat.component.html'
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
        this._consultTermService.getConsultTermsInfo().subscribe(
            data=> {
                this.consultTerms = data;
                this.consultTerms.forEach(function (value){
                    console.log(value.date);
                });
            }, error => {
                console.log("Error in getting consult term data!")
            });
        console.log(this.selectedDate);
    }
}