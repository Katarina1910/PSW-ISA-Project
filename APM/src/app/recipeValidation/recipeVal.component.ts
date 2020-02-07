import { Component, OnInit } from '@angular/core';
import { Recipe } from '../ConsultTermReport/Recipe';
import { recipeValService } from './recipeVal.service';


@Component({
    selector: 'recipe-val',
    templateUrl: './recipeVal.component.html'
})

export class RecipeValidation implements OnInit{


    constructor(private _recipeValService: recipeValService){}

    ngOnInit(): void {
        this._recipeValService.getAll(localStorage.getItem("user-id")).subscribe(
            data=>{
                    this.recipes = data;
            },error=>{

            }
        );
    }

    

    public recipes : Recipe[];

    private certify(id: number){
        this._recipeValService.certify(id).subscribe(
            data=>{
                    alert("Succesfully certified");
                   
            },error=>{
                    alert("Already certified or gone");
            }
        );

    }

    

}