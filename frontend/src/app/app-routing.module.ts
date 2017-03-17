import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { UsersComponent } from "./users/users.component";
import {UserSearchComponent} from "./users/user-search.component";
import {LoginComponent} from "./login/login.component";

const routes: Routes = [
    { path: '', redirectTo: '', pathMatch: 'full' },
    { path: 'users', component: UsersComponent },
    { path: 'search', component: UserSearchComponent },
    { path: 'login', component: LoginComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }