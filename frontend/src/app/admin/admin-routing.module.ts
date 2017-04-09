import {NgModule} from "@angular/core";
import {Routes, RouterModule} from "@angular/router";
import {AdminComponent} from "./admin.component";
import {UserComponent} from "../user/all/user.component";
import {UserSearchComponent} from "../user/search/user-search.component";
import {PictureAddComponent} from "../picture/add/picture-add.component";
import {UserEditComponent} from "../user/edit/user-edit.component";

const routes: Routes = [
    {
        path: 'admin', component: AdminComponent,
        children: [
            {path: 'users', component: UserComponent},
            {path: 'search', component: UserSearchComponent},
            {path: 'picture/add', component: PictureAddComponent},
            {path: 'users/edit/:id', component: UserEditComponent},
        ]
    },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AdminRoutingModule {
}