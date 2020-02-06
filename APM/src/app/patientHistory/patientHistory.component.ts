import { Component, OnInit } from '@angular/core';
import { RequestForConsultService } from '../requestForConsult/requestForConsult.service';
import { UserService } from '../registration/user.service';
import { User } from '../registration/user';
import { ConsultTerm } from '../consultTerm/consultTerm';
import { RequestForConsult } from '../requestForConsult/requestForConsult';
import { Sort } from '@angular/material';
import { ConsultTermService } from '../consultTerm/consultTerm.service';

@Component({
    selector : 'cc-patientHistory',
    templateUrl : './patientHistory.component.html'
})

export class patientHistory implements OnInit{

    user: User = new User("","","","","","","","","","","","");
    private consultTerms: RequestForConsult[];
    private sortedRequests: RequestForConsult[];

    constructor(private _consultTermService: ConsultTermService,
                private userService: UserService) {}
  
    ngOnInit(): void {
        this.getUserInfo();
        this._consultTermService.getConsultTerms(2).subscribe(
            data => {
                this.consultTerms = data;
                console.log(this.consultTerms);
            },error => {
                console.log("Error in getting request for consult term data!")
            }
        )
        
        console.log(this.consultTerms);
        
    }

    getUserInfo(): void {
        this.userService.getUserInfo().subscribe(data => {
          this.user = data;
        }, error => {
          console.log("Error in getting user data!")
        });
    }
    
    //sortiranje
    sortData(sort: Sort) {
        const data = this.consultTerms;
        if (!sort.active || sort.direction === '') {
          this.sortedRequests = data;
          return;
        }
    
        this.sortedRequests = data.sort((a, b) => {
          const isAsc = sort.direction === 'asc';
          switch (sort.active) {
            case 'type': return compare(a.type, b.type, isAsc);
            case 'date': return compare(a.date, b.date, isAsc);
            case 'price': return compare(a.price, b.price, isAsc);
            default: return 0;
          }
        });
    }
}

function compare(a: number | string | Date, b: number | string | Date, isAsc: boolean) {
    return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}