
    import { Component } from '@angular/core';
    import { arrivedRequestService } from './arrivedRequest.service';

    @Component({
        selector: 'cca-arrivrequest',
        templateUrl: './arrivedRequest.component.html'
    })

    export class arrivedRequest{

        public arrReq : arrivedRequest[];
        constructor(private _arrivedRequestService: arrivedRequestService) {}

        onLoad(){
            this._arrivedRequestService.getArrivedRequests().subscribe(
            data=> 
            {
                this.arrReq = data;
                console.log('Success!', data)
            },
                error=> console.error('Error!',error)
            )
        }
    }

