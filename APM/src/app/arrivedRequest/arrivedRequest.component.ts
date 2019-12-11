    import { Component, OnInit } from '@angular/core';
    import { arrivedRequestService } from './arrivedRequest.service';

    @Component({
        selector: 'cca-arrivrequest',
        templateUrl: './arrivedRequest.component.html'
    })

    export class arrivedRequest implements OnInit{

        public arrReq : arrivedRequest[];
        public pomocnaId: any;
        constructor(private _arrivedRequestService: arrivedRequestService) {}

        ngOnInit(){
            this._arrivedRequestService.getArrivedRequests().subscribe(
                data=>{
                    console.log('Success!', JSON.stringify(data))
                    this.arrReq = data;
                },
                error=>console.error('Error!',error)
            )
        }
        
        onClick(id:any): void{
            this._arrivedRequestService.sendActivationEmail(id, this.arrReq).subscribe(
            data=> {
                alert('Request has been sent!')
                console.log('Success!', JSON.stringify(data))
            },
            error=> console.error('Error!',error)
            )
/*
            this._arrivedRequestService.addPatient(id, this.arrReq).subscribe(
                data=> {
                    alert('Patient added!')
                    console.log('Success!', JSON.stringify(data))
                },
                error=> console.error('Error!',error)
            )
*/
        }

        onClickReject(id:any): void{
            this.pomocnaId = id;
        }

        onClickSendMessage(): void{
            this._arrivedRequestService.sendRejectEmail(this.pomocnaId).subscribe(
            data=> {
                alert('Reject has been sent!')
                console.log('Success!', JSON.stringify(data))
            },
            error=> console.error('Error!',error)
        )
        }

    }