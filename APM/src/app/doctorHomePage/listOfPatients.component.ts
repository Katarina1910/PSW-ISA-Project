import { Component, OnInit } from '@angular/core';
import { listOfPatients } from './listOfPatients';
import { listOfPatientsService } from './listOfPatients.service';



@Component({
    selector: 'pat-listOfPatients',
    templateUrl: './listOfPatients.component.html'
})

export class listOfPatientsDoctor implements OnInit{

    public listPatients : listOfPatients[];
    public filteredPatients : listOfPatients[];
    public pListPat: listOfPatients[] = [];
    public _patientUCIDN: string;
    public _patientName: string;
    public _patientSurname: string;


    constructor(private _listOfPatientsService: listOfPatientsService) {}

    get patientName():string{
        return this._patientName;
    }

    set  patientName(value:string){
        this._patientName=value;
        this.filteredPatients = this.patientName ? this.filter(this.patientName):this.listPatients;
    }
    filter(filterField:string):listOfPatients[]{
        filterField = filterField.toLocaleLowerCase();
        return this.listPatients.filter((pat:listOfPatients)=>pat.name.toLowerCase().indexOf(filterField)!=-1);
    }

    get patientUCIDN():string{
        return this._patientUCIDN;
    }

    set patientUCIDN(value:string){
        this._patientUCIDN=value;
        this.filteredPatients = this.patientUCIDN ? this.filter3(this.patientUCIDN):this.listPatients;
    }
    
    filter3(filterField:string):listOfPatients[]{
        filterField = filterField.toLocaleLowerCase();
        return this.listPatients.filter((pat:listOfPatients)=>pat.ucidn.toLowerCase().indexOf(filterField)!=-1);
    }

    get patientSurname():string{
        return this._patientSurname;
    }

    set patientSurname(value:string){
        this._patientSurname=value;
        this.filteredPatients = this.patientSurname ? this.filter2(this.patientSurname):this.listPatients;
    }
    
    filter2(filterField:string):listOfPatients[]{
        filterField = filterField.toLocaleLowerCase();
        return this.listPatients.filter((pat:listOfPatients)=>pat.surname.toLowerCase().indexOf(filterField)!=-1);
    }


    ngOnInit(){
        this._listOfPatientsService.getListOgPatients().subscribe(
            data=>{
                this.listPatients = data;
                this.filteredPatients = data;
                console.log(this.listPatients);
            },
            error=>console.error('Error!',error)
        )
        console.log(this.filteredPatients);
    }

}