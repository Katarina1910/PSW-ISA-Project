import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../registration/user';
import { UserService } from '../registration/user.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-profile-page',
  templateUrl: './PatientProfilePage.component.html',
  styleUrls: ['./PatientProfilePage.component.css']
})
export class PatientProfilePageComponent implements OnInit {

  user: User = new User("","","","","","","","","","","","","");
  
  private userId: number;
  http: any;

  constructor(private route: ActivatedRoute,
              private userService: UserService) { 
  }

  ngOnInit() {
    this.userId = Number(this.route.snapshot.paramMap.get('id'));
    //this.userId = Number(this.user.getId);
    console.log('User ID: ', this.userId);
    this.getUserInfo();
  }

  getUserInfo(): void {
    this.userService.getUser(this.userId).subscribe(data => {
      this.user = data;
    }, error=>console.error('Error while getting data about user!',error));
  }
}
