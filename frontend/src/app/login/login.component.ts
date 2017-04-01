import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {AuthenticationService} from '../authentication/authentication.service';

@Component({
    selector: 'login-component',
    templateUrl: 'login.component.html'
})

export class LoginComponent implements OnInit {
    auth: any = {};
    loading = false;
    error = '';

    constructor(
        private router: Router,
        private authenticationService: AuthenticationService) { }

    ngOnInit() {
        this.authenticationService.logout();
    }

    login() {
        this.loading = true;
        this.authenticationService.login(this.auth.username, this.auth.password)
            .subscribe(result => {
                if (result === true) {
                    this.router.navigate(['/']);
                } else {
                    this.error = 'Username or password is incorrect';
                    this.loading = false;
                }
            },
            error => {
                this.error = 'Username or password is incorrect';
                this.loading = false;
            });
    }
}