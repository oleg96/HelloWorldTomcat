import {NgModule} from '@angular/core';
import {HttpModule} from '@angular/http';
import {FormsModule} from "@angular/forms";
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from "../app-routing.module";
import {RegisterService} from "./register.service";
import {RegisterComponent} from "./register.component";

@NgModule({
    imports: [ AppRoutingModule, BrowserModule, HttpModule, FormsModule ],
    declarations: [ RegisterComponent ],
    providers: [ RegisterService ]
})

export class RegisterModule { }