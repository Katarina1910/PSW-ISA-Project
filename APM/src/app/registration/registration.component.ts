import { Component } from '@angular/core';
import { User } from './user';
import { UserService } from './user.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
    selector : 'cc-registration',
    templateUrl : './registration.component.html'
})
export class RegistrationComponent{
    userModel = new User("hi"," "," "," "," "," "," "," "," "," "," ","");
    
    registerForm: FormGroup;
    submitted = false;
    done:boolean = false;
    
    constructor(private _userService: UserService, private formBuilder: FormBuilder, private router: Router) {}

    ngOnInit() {
        this.registerForm = this.formBuilder.group({
            name: ['', Validators.required],
            surname: ['', Validators.required],
            ucidn: ['', Validators.required],
            address: ['', Validators.required],
            city: ['', Validators.required],
            country: ['', Validators.required],
            phoneNumber: ['', Validators.required],
            username: ['', Validators.required],
            email: ['', [Validators.required, Validators.email]],
            password: ['', [Validators.required, Validators.minLength(6)]]
        });
    }
    get f() { return this.registerForm.controls; }

    onSubmit(){
        console.log('Print: ', this.userModel)
        this._userService.enroll(this.userModel)
        .subscribe(
            data=> {
                alert('Request has been sent!')
                this.done=true;
                this.router.navigate(['/welcome']);
            
                console.log('Success!', JSON.stringify(data))
            },
            error=> console.error('Error!',error)
        )
        this.submitted = true;
        if (this.registerForm.invalid) {
            return;
        }

        alert('Registered')
    }
    
}

