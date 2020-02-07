    import { Component, OnInit } from '@angular/core';
    import { arrivedRequestService } from './arrivedRequest.service';
import { Router } from '@angular/router';

    @Component({
        selector: 'cca-arrivrequest',
        templateUrl: './arrivedRequest.component.html'
    })

    export class arrivedRequest implements OnInit{

        public arrReq : arrivedRequest[];
        public pomocnaId: any;
        public email:any;
        public reason:string;
        constructor(private _arrivedRequestService: arrivedRequestService,  private router: Router) {}

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
                console.log('Success!', JSON.stringify(data));
            },
            error=> console.error('Error!',error)
            )
        }

        onClickReject(id:any,email:any): void{
            this.pomocnaId = id;
            this.email = email;
        }

        onClickSendMessage(): void{
            
            this._arrivedRequestService.sendRejectEmail(this.email, this.reason,this.pomocnaId).subscribe(
            data=> { 
            },
            error=> console.error('Error!',error));
            alert('Reject email has been sent!');
            this.router.navigate(['/HomepageCCA']);
        }

    }