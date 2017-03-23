import {NgModule} from '@angular/core';
import {HttpModule} from '@angular/http';
import {FormsModule} from "@angular/forms";
import {BrowserModule} from '@angular/platform-browser';
import {LogService} from "./log/log.service";
import {AppComponent} from "./app.component";
import {AppRoutingModule} from "./app-routing.module";
import {RouterModule} from "@angular/router";
import {LoginComponent} from "./login/login.component";
import {AuthenticationService} from "./authentication/authentication.service";
import {AuthenticationGuard} from "./guard/authentication.guard";
import {LogoutComponent} from "./logout/logout.component";
import {PictureModule} from "./picture/picture.module";
import {UserModule} from "./user/user.module";

@NgModule({
    imports: [ AppRoutingModule, RouterModule, BrowserModule, HttpModule, FormsModule, PictureModule, UserModule ],
    declarations: [ AppComponent, LoginComponent, LogoutComponent ],
    providers: [ LogService, AuthenticationService, AuthenticationGuard ],
    bootstrap: [ AppComponent ]
})

export class AppModule { }