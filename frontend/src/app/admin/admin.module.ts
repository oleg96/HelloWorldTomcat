import {NgModule} from '@angular/core';
import {HttpModule} from '@angular/http';
import {FormsModule} from "@angular/forms";
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from "@angular/router";
import {PictureModule} from "../picture/picture.module";
import {UserModule} from "../user/user.module";
import {AdminComponent} from "./admin.component";
import {AdminRoutingModule} from "./admin-routing.module";

@NgModule({
    imports: [ AdminRoutingModule, RouterModule, BrowserModule, HttpModule, FormsModule, PictureModule, UserModule ],
    declarations: [ AdminComponent ],
})

export class AdminModule { }