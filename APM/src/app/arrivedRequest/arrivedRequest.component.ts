    import { Component, OnInit } from '@angular/core';
    import { arrivedRequestService } from './arrivedRequest.service';

    @Component({
        selector: 'cca-arrivrequest',
        templateUrl: './arrivedRequest.component.html'
    })

    export class arrivedRequest implements OnInit{

        public arrReq : arrivedRequest[];
        public pomocnaId: any;
        public email:any;
        public reason:string;
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
        
        onClick(id:any,email:any): void{
            this._arrivedRequestService.sendActivationEmail(id,email, this.arrReq).subscribe(
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

        onClickReject(id:any,email:any): void{
            this.pomocnaId = id;
            this.email = email;
        }

        onClickSendMessage(): void{
            this._arrivedRequestService.sendRejectEmail(this.email,this.reason).subscribe(
            data=> {
                alert('Reject has been sent!')
                console.log('Success!', JSON.stringify(data))
            },
            error=> console.error('Error!',error)
        )
        }

    }