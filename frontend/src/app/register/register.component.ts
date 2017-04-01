import {Component} from '@angular/core';
import {Router} from "@angular/router";
import {RegisterService} from "./register.service";

@Component({
    selector: 'register-component',
    templateUrl: 'register.component.html',
})

export class RegisterComponent {
    reg: any = {};
    loading = false;
    error = '';

    constructor(private router: Router,
                private registerService: RegisterService) {
    }

    register() {
        this.loading = true;
        if (this.reg.password !== this.reg.repeatPassword) {
            this.error = 'Password and it confirmation does not equals';
            this.loading = false;
        }
        else this.registerService.register(this.reg.username, this.reg.password)
            .subscribe(result => {
                    if (result === true) {
                        this.router.navigate(['/']);
                    } else {
                        this.error = 'Error while registering';
                        this.loading = false;
                    }
                },
                error => {
                    this.error = 'Error while registering';
                    this.loading = false;
                });
    }
}