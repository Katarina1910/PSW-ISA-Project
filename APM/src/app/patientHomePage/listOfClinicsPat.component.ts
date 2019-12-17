import { Component, OnInit } from '@angular/core';
import { listOfClinicsPatService } from './listOfClinicsPat.service';
import { listOfClinicsPat } from './listOfClinicsPat';
import { DeleteConsultTypeService } from '../consultType/deleteConsultType.service';
import { ConsultType } from 'src/consultType/consultType';


@Component({
    selector: 'pat-listOfClinics',
    templateUrl: './listOfClinicsPat.component.html'
})

export class ListOfPatClinics implements OnInit{

    public listClin : listOfClinicsPat[];
    public types: ConsultType[];
    public _clinicAdress: string;
    public filteredClinics: listOfClinicsPat[];

    constructor(private _listOfClinicsService: listOfClinicsPatService, 
                private _deleteConsultTypeService: DeleteConsultTypeService) {}

    get clinicAddress():string{
        return this._clinicAdress;
    }

    set clinicAddress(value:string){
        this._clinicAdress=value;
        this.filteredClinics = this.clinicAddress ? this.filter(this.clinicAddress):this.listClin;
    }

    filter(filterField:string):listOfClinicsPat[]{
        filterField = filterField.toLocaleLowerCase();
        return this.listClin.filter((clinic:listOfClinicsPat)=>clinic.address.toLowerCase().indexOf(filterField)!=-1);
    }

    ngOnInit(){
        this._listOfClinicsService.getListOfClinics().subscribe(
            data=>{
                this.listClin = data;
            },
            error=>console.error('Error!',error)
        )
        this._deleteConsultTypeService.getConsultTypes().subscribe(
            data=>this.types = data,
            error=> console.error('Error!', error)
        )
        this.filteredClinics = this.listClin;
    }

}