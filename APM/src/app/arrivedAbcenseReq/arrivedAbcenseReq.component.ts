import { Component, OnInit } from '@angular/core';
import { RequestForAbsence } from '../requestForAbsence/requestForAbsence';
import { arrivedAbcenseReqService } from './arrivedAbcenseReq.service';

    @Component({
        selector: 'cca-arrivrequest',
        templateUrl: './arrivedAbcenseReq.component.html'
    })

    export class arrivedAbsenceReqComponent implements OnInit{

        public arrReq : RequestForAbsence[];
        public pomocnaId: any;
        public email:any;
        public reason:string;
        constructor(private _arrivedRequestService: arrivedAbcenseReqService) {}

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
            console.log(this.reason)
            this._arrivedRequestService.sendRejectEmail(this.email,this.reason,this.pomocnaId).subscribe(
            data=> {
                alert('Reject email has been sent!')
                console.log('Success!', JSON.stringify(data))
            },
            error=> console.error('Error!',error))

           /* this._arrivedRequestService.removeArrivedRequest(this.pomocnaId).subscribe(
                data=> {
                    alert('Request has been removed')
                    console.log('Success!', JSON.stringify(data))
                },
                error=> console.error('Error!',error))
            }*/

        }
        

    }