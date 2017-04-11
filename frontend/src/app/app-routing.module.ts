import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from "./login/login.component";
import {LogoutComponent} from "./logout/logout.component";
import {AuthenticationGuard} from "./guard/authentication.guard";
import {PictureAllComponent} from "./picture/all/picture-all.component";
import {PictureComponent} from "./picture/details/picture-details.component";
import {RegisterComponent} from "./register/register.component";
import {PictureEditComponent} from "./picture/edit/picture-edit.component";

const routes: Routes = [
    {path: '', redirectTo: '', pathMatch: 'full'},
    {path: 'pictures/all', component: PictureAllComponent},
    {path: 'pictures/:id', component: PictureComponent},
    {path: 'pictures/edit/:id', component: PictureEditComponent},
    {path: 'login', component: LoginComponent},
    {path: 'logout', component: LogoutComponent, canActivate: [AuthenticationGuard]},
    {path: 'register', component: RegisterComponent},
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}