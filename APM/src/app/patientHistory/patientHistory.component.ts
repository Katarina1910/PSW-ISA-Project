import { Component, OnInit } from '@angular/core';
import { RequestForConsultService } from '../requestForConsult/requestForConsult.service';
import { UserService } from '../registration/user.service';
import { User } from '../registration/user';
import { ConsultTerm } from '../consultTerm/consultTerm';
import { RequestForConsult } from '../requestForConsult/requestForConsult';
import { Sort } from '@angular/material';
import { ConsultTermService } from '../consultTerm/consultTerm.service';
import { AddDoctorService } from '../doctor/addDoctor.service';

@Component({
    selector : 'cc-patientHistory',
    templateUrl : './patientHistory.component.html'
})

export class patientHistory implements OnInit{

    user: User = new User("","","","","","","","","","","","");
    private consultTerms: ConsultTerm[];
    private sortedTerms: ConsultTerm[];
    currentRate = 3;

    constructor(private _consultTermService: ConsultTermService,
                private userService: UserService,
                private addDoctorService: AddDoctorService) {}
  
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

    rateDoctor(ct: ConsultTerm): void {
      const rate = ct.doctor.grade;
      this.addDoctorService.rateDoctor(ct.doctor, rate).subscribe(
        data=> {
          alert('Doctors grade is sent!')
        },
        error=> console.error('Error rating!',error))
      console.log("ocena doktora: ",rate);
    }
    
    //sortiranje
    sortData(sort: Sort) {
        const data = this.consultTerms;
        if (!sort.active || sort.direction === '') {
          this.sortedTerms = data;
          return;
        }
    
        this.sortedTerms = data.sort((a, b) => {
          const isAsc = sort.direction === 'asc';
          switch (sort.active) {
            case 'type': return compare(a.type.name, b.type.name, isAsc);
            case 'date': return compare(a.date, b.date, isAsc);
            case 'price': return compare(a.price, b.price, isAsc);
            case 'discount': return compare(a.discount, b.discount, isAsc);
            case 'duration': return compare(a.duration, b.duration, isAsc);
            case 'doctor': return compare(a.doctor.name, b.doctor.name, isAsc);
            case 'room': return compare(a.room.name, b.room.name, isAsc);
            default: return 0;
          }
        });
    }
}

function compare(a: number | string | Date, b: number | string | Date, isAsc: boolean) {
    return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}