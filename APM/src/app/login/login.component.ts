import { Component } from '@angular/core';
import { Login } from './login';
import { LoginService } from './login.service';
import { User } from '../registration/user';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { USER_ID_KEY, USER_ROLE_KEY, USERNAME_KEY, USER_TOKEN_KEY } from '../config/local-storage-keys';
import { UserService } from '../registration/user.service';
import { takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';
import { DisplayMessage } from '../shared/models/display-message';

@Component({
    selector : 'cc-login',
    templateUrl : './login.component.html'
})
export class LoginComponent{
    loginModel = new Login('','');
    u:User = null;
    loginForm: FormGroup;
    submitted = false;
    private user:User;
    returnUrl: string;
    private ngUnsubscribe: Subject<void> = new Subject<void>();
    notification: DisplayMessage;
    form: FormGroup;

    constructor(private _loginService: LoginService, 
                private formBuilder: FormBuilder, 
                private router: Router,
                private route: ActivatedRoute,
                private _isUser: UserService){ }

    ngOnInit() {
        this.route.params
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((params: DisplayMessage) => {
            this.notification = params;
        });
        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
        this.form = this.formBuilder.group({
        username: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(64)])],
        password: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(32)])]
        });

        /**
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', [Validators.required, Validators.minLength(3)]],
        });
        **/
    }

    ngOnDestroy() {
        this.ngUnsubscribe.next();
        this.ngUnsubscribe.complete();
    }

    get f() { return this.loginForm.controls; }
    
    onClickLogin(){
        this.notification = undefined;
        this.submitted = true;
        this._loginService.login(this.loginModel)
       .subscribe(
        data => {
            this.u = data as User;
            sessionStorage.setItem("user",JSON.stringify(this.u));
            data = data as User;        
            console.log(data);
            
            localStorage.setItem(USER_ID_KEY, data.id);
            localStorage.setItem(USER_ROLE_KEY, data.authorities);
            localStorage.setItem(USERNAME_KEY, data.email);
            localStorage.setItem(USER_TOKEN_KEY, data.token.accessToken);
            localStorage.setItem(USER_ROLE_KEY, data.role)
            
            alert("Logged in!");

            if(this._isUser.isUserLoggedIn()) {
                this.user = JSON.parse(sessionStorage.getItem("user"));
                if(this.user.role==="ROLE_PATIENT"){
                    this.router.navigate(['/HomepagePatient']);
                } else if(this.user.role==="ROLE_DOCTOR") {
                    this.router.navigate(['/HomepageDoctor']);
                } else if(this.user.role==="ROLE_CA") {
                    this.router.navigate(['/HomepageCA'])
                } else if(this.user.role==="ROLE_CCA") {
                    this.router.navigate(['/HomepageCCA']);
                } else if(this.user.role==="ROLE_NURSE") {
                    this.router.navigate(['/HomepageNurse']);
                }else{
                    this.router.navigate(['']);
                }
            }
            
             
        },
        error=> { 
            alert("Wrong password or username")
            this.submitted = false;
        });
        this.submitted = true;
    }
}