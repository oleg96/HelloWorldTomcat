import {NgModule} from '@angular/core';
import {HttpModule} from '@angular/http';
import {FormsModule} from "@angular/forms";
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from "../app-routing.module";
import {PictureAllComponent} from "./all/picture-all.component";
import {PictureComponent} from "./details/picture-details.component";
import {SecureUrlPipe} from "./secure-url.pipe";
import {PictureService} from "./picture.service";
import {PictureAddComponent} from "./add/picture-add.component";

@NgModule({
    imports: [ AppRoutingModule, BrowserModule, HttpModule, FormsModule ],
    declarations: [ PictureAddComponent, PictureAllComponent, PictureComponent, SecureUrlPipe ],
    providers: [ PictureService ]
})

export class PictureModule { }