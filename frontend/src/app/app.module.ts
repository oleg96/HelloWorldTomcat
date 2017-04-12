import {NgModule} from "@angular/core";
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {BrowserModule} from "@angular/platform-browser";
import {LogService} from "./log/log.service";
import {AppComponent} from "./app.component";
import {AppRoutingModule} from "./app-routing.module";
import {RouterModule} from "@angular/router";
import {LoginComponent} from "./login/login.component";
import {AuthenticationService} from "./authentication/authentication.service";
import {AuthenticationGuard} from "./guard/authentication.guard";
import {LogoutComponent} from "./logout/logout.component";
import {PictureModule} from "./picture/picture.module";
import {LocationStrategy, HashLocationStrategy} from "@angular/common";
import {RegisterModule} from "./register/register.module";
import {AdminModule} from "./admin/admin.module";
import {AuthorityComponent} from "./authority/authority.component";
import {TranslatePipe} from "./translate/translate.pipe";
import {TRANSLATION_PROVIDERS} from "./translate/translations";
import {TranslateService} from "./translate/translate.service";

@NgModule({
    imports: [AppRoutingModule, RouterModule, BrowserModule, HttpModule, FormsModule, PictureModule, RegisterModule, AdminModule],
    declarations: [AppComponent, LoginComponent, LogoutComponent, TranslatePipe],
    providers: [LogService, AuthenticationService, AuthenticationGuard, AuthorityComponent, TRANSLATION_PROVIDERS, TranslateService, {
        provide: LocationStrategy,
        useClass: HashLocationStrategy
    }],
    bootstrap: [AppComponent]
})

export class AppModule {
}