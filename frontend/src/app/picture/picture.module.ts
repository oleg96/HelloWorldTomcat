import {NgModule} from "@angular/core";
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {BrowserModule} from "@angular/platform-browser";
import {AppRoutingModule} from "../app-routing.module";
import {PictureAllComponent} from "./all/picture-all.component";
import {PictureComponent} from "./details/picture-details.component";
import {SecureUrlPipe} from "./secure-url.pipe";
import {PictureService} from "./picture.service";
import {PictureAddComponent} from "./add/picture-add.component";
import {UPLOAD_DIRECTIVES} from "ngx-uploader";
import {PictureEditComponent} from "./edit/picture-edit.component";
import {AuthorityComponent} from "../authority/authority.component";
import {AuthenticationGuard} from "../guard/authentication.guard";

@NgModule({
    imports: [ AppRoutingModule, BrowserModule, HttpModule, FormsModule ],
    declarations: [ PictureAddComponent, PictureAllComponent, PictureComponent, PictureEditComponent, SecureUrlPipe, UPLOAD_DIRECTIVES ],
    providers: [ PictureService, AuthenticationGuard, AuthorityComponent ]
})

export class PictureModule { }