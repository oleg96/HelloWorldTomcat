import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { UsersComponent } from "./users/users.component";
import {UserSearchComponent} from "./users/user-search.component";
import {LoginComponent} from "./login/login.component";
import {LogoutComponent} from "./logout/logout.component";
import {AuthenticationGuard} from "./guard/authentication.guard";
import {PictureAllComponent} from "./picture/all/picture-all.component";

const routes: Routes = [
    { path: '', redirectTo: '', pathMatch: 'full' },
    { path: 'users', component: UsersComponent },
    { path: 'search', component: UserSearchComponent },
    { path: 'pictures/all', component: PictureAllComponent },
    { path: 'login', component: LoginComponent },
    { path: 'logout', component: LogoutComponent, canActivate: [AuthenticationGuard] },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }