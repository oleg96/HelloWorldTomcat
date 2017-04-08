import {Component} from '@angular/core';
import {AuthenticationGuard} from "./guard/authentication.guard";
import {AuthorityComponent} from "./authority/authority.component";

@Component({
    selector: 'app',
    templateUrl: './app.component.html'
})
export class AppComponent {

    constructor(public auth: AuthenticationGuard, public authority: AuthorityComponent) { }
}