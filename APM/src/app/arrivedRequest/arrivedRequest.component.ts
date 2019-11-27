    import { Component, OnInit } from '@angular/core';
    import { arrivedRequestService } from './arrivedRequest.service';

    @Component({
        selector: 'cca-arrivrequest',
        templateUrl: './arrivedRequest.component.html'
    })

    export class arrivedRequest implements OnInit{

        public arrReq : arrivedRequest[];
        constructor(private _arrivedRequestService: arrivedRequestService) {}

        ngOnInit(){
            this._arrivedRequestService.getArrivedRequests().subscribe(
                data=>{
                    this.arrReq = data;
                },
                error=>console.error('Error!',error)
            )
        }

        onClick(){
            console.log("Katarina");
        }
    }