import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { ConsultType } from 'src/consultType/consultType';
import { DeleteConsultTypeService } from './deleteConsultType.service';




@Component({
    selector: 'ca-delCosultType',
    templateUrl: './deleteConsultType.component.html'
})

export class DeleteConsultTypeComponent implements OnInit {
    public types: ConsultType[];
   
    
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

}