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
        }

        onClickReject(id:any,email:any): void{
            this.pomocnaId = id;
            this.email = email;
        }

        onClickSendMessage(): void{
            this._arrivedRequestService.sendRejectEmail(this.email,this.reason,this.pomocnaId).subscribe(
            data=> {
                alert('Reject email has been sent!')
                console.log('Success!', JSON.stringify(data))
            },
            error=> console.error('Error!',error))
/*
            this._arrivedRequestService.removeArrivedRequest(this.pomocnaId).subscribe(
                data=> {
                    alert('Request has been removed')
                    console.log('Success!', JSON.stringify(data))
                },
                error=> console.error('Error!',error))
*/
        }

    }