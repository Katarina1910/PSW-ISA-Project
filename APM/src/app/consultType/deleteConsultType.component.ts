import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { DeleteConsultTypeService } from './deleteConsultType.service';
import { ConsultType } from 'src/consultType/consultType';

@Component({
    selector: 'ca-delCosultType',
    templateUrl: './deleteConsultType.component.html'
})

export class DeleteConsultTypeComponent implements OnInit {
    public types: ConsultType[];
   editModel = new ConsultType(null,null);
    edit : boolean = false;
    public editedType:ConsultType;
   
    
    constructor(private _deleteConsultTypeService: DeleteConsultTypeService,private router: Router) {}


    ngOnInit() { 
        this._deleteConsultTypeService.getConsultTypes().subscribe(
        data=>{
          
            this.types = data;
            for(var d of this.types){
                console.log(JSON.stringify(d));
            }

        },
        error=> console.error('Error!', error)
    ) }

    
    deleteConsultType(id:number): void{
        this._deleteConsultTypeService.deleteConsultType(id).subscribe(
            data=>{
                alert('Consult type deleted!');
                this.router.navigate(['/HomepageCA']);
            },
            error=> console.error('Error!', error)
        )
       
    }

    editConsultType(d:ConsultType):void{   
        this.edit = true;
        this.editModel.name = d.name;
        this.editModel.description = d.description;
        this.editModel.id = d.id;
    }

    onSubmit(){
        this._deleteConsultTypeService.editCOnsutType(this.editModel).subscribe(
            data=>{
                alert('Consult type edited!');
                this.editedType = data as ConsultType;
                
                this.router.navigate(['/HomepageCA']);
            },
            error=> console.error('Error!', error)
        )
        this.edit = false; 
    }

}