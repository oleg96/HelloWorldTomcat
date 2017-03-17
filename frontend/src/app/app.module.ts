import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from "@angular/forms";
import { BrowserModule} from '@angular/platform-browser';
import { UsersComponent } from './users/users.component';
import { UserService } from "./users/user.service";
import { LogService } from "./log/log.service";
import { AppComponent } from "./app.component";
import { AppRoutingModule } from "./app-routing.module";
import { RouterModule } from "@angular/router";
import { UserSearchComponent } from "./users/user-search.component";
import {LoginComponent} from "./login/login.component";
import {AuthenticationService} from "./authentication/authentication.service";
import {AuthenticationGuard} from "./guard/authentication.guard";

@NgModule({
    imports: [ AppRoutingModule, RouterModule, BrowserModule, HttpModule, FormsModule ],
    declarations: [ AppComponent, UsersComponent, UserSearchComponent, LoginComponent ],
    providers: [ UserService, LogService, AuthenticationService, AuthenticationGuard ],
    bootstrap: [ AppComponent ]
})

export class AppModule { }