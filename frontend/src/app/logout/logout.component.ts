import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {AuthenticationService} from '../authentication/authentication.service';

@Component({
    selector: 'logout-component',
    templateUrl: 'logout.component.html'
})

export class LogoutComponent implements OnInit {

    constructor(
        private router: Router,
        private authenticationService: AuthenticationService) { }

    ngOnInit() {
        // reset login status
        this.authenticationService.logout();
        this.router.navigate(['/']);
    }
}