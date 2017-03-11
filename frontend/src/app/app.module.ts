import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { BrowserModule} from '@angular/platform-browser';
import { UsersComponent } from './users/users.component';
import { UserService } from "./users/user.service";
import { LogService } from "./log/log.service";
import { AppComponent } from "./app.component";
import { AppRoutingModule } from "./app-routing.module";
import { RouterModule } from "@angular/router";
import { UserSearchComponent } from "./users/user-search.component";

@NgModule({
    imports: [ AppRoutingModule, RouterModule, BrowserModule, FormsModule ],
    declarations: [ AppComponent, UsersComponent, UserSearchComponent ],
    providers: [ UserService, LogService ],
    bootstrap: [ AppComponent ]
})

export class AppModule { }