import {NgModule} from "@angular/core";
import {Routes, RouterModule} from "@angular/router";
import {UserComponent} from "./user/all/user.component";
import {UserSearchComponent} from "./user/search/user-search.component";
import {LoginComponent} from "./login/login.component";
import {LogoutComponent} from "./logout/logout.component";
import {AuthenticationGuard} from "./guard/authentication.guard";
import {PictureAllComponent} from "./picture/all/picture-all.component";
import {PictureComponent} from "./picture/details/picture-details.component";
import {RegisterComponent} from "./register/register.component";
import {PictureAddComponent} from "./picture/add/picture-add.component";
import {AdminComponent} from "./admin/admin.component";

const routes: Routes = [
    { path: '', redirectTo: '', pathMatch: 'full' },
    { path: 'pictures/all', component: PictureAllComponent },
    { path: 'pictures/:id', component: PictureComponent },
    { path: 'login', component: LoginComponent },
    { path: 'logout', component: LogoutComponent, canActivate: [AuthenticationGuard] },
    { path: 'register', component: RegisterComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }