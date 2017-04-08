import {NgModule} from '@angular/core';
import {HttpModule} from '@angular/http';
import {FormsModule} from "@angular/forms";
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from "../app-routing.module";
import {UserComponent} from "./all/user.component";
import {UserSearchComponent} from "./search/user-search.component";
import {UserService} from "./user.service";
import {UserEditComponent} from "./edit/user-edit.component";

@NgModule({
    imports: [ AppRoutingModule, BrowserModule, HttpModule, FormsModule ],
    declarations: [ UserComponent, UserSearchComponent, UserEditComponent ],
    providers: [ UserService ]
})

export class UserModule { }