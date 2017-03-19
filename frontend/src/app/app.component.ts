import { Component } from '@angular/core';
import {AuthenticationGuard} from "./guard/authentication.guard";

@Component({
    selector: 'app',
    templateUrl: './app.component.html'
})
export class AppComponent {

    constructor(public auth: AuthenticationGuard) { }
}