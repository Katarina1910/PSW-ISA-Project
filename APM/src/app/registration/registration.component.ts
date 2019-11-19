import { Component } from '@angular/core';
import { User } from './user';
import { UserService } from './user.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
    selector : 'cc-registration',
    templateUrl : './registration.component.html'
})
export class RegistrationComponent{
    userModel = new User("hi"," "," "," "," "," "," "," "," "," "," ");
    
    
    registerForm: FormGroup;
    submitted = false;
    
    constructor(private _userService: UserService, private formBuilder: FormBuilder) {}

    ngOnInit() {
        this.registerForm = this.formBuilder.group({
            firstName: ['', Validators.required],
            lastName: ['', Validators.required],
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

    // convenience getter for easy access to form fields
    get f() { return this.registerForm.controls; }

    onSubmit(){
        this._userService.enroll(this.userModel)
        .subscribe(
            data=> console.log('Success!', data),
            error=> console.error('Error!',error)
        )
        
        //validacija
        this.submitted = true;

        // stop here if form is invalid
        if (this.registerForm.invalid) {
            return;
        }

        alert('Registered')
    }

}

