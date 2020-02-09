import { Component, OnInit } from '@angular/core';
import { Recipe } from '../ConsultTermReport/Recipe';
import { recipeValService } from './recipeVal.service';


@Component({
    selector: 'recipe-val',
    templateUrl: './recipeVal.component.html'
})

export class RecipeValidation implements OnInit{
    

    public recipes : Recipe[];

    constructor(private _recipeValService: recipeValService){}

    ngOnInit(): void {
        this._recipeValService.getAll(localStorage.getItem("user-id")).subscribe(
            data=>{
                    this.recipes = data;
            },error=>{

            }
        );
    }

    refresh():void{
        this._recipeValService.getAll(localStorage.getItem("user-id")).subscribe(
            data=>{
                    this.recipes = data;
            },error=>{

            }
        );
    }

   
     certify(id: number){
        this._recipeValService.certify(id, localStorage.getItem("user-id")).subscribe(
            data=>{
                    alert("Succesfully certified");
                    this.refresh();
                   
            },error=>{
                    alert("Already certified or gone");
            }
        );

    }

    

}