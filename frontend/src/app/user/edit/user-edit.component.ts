import {Component} from '@angular/core';
import {ActivatedRoute, Params, Router} from "@angular/router";
import {UserService} from "../user.service";
import {User} from "../../model/user";

@Component({
    selector: 'user-edit-component',
    templateUrl: 'user-edit.component.html',
})

export class UserEditComponent {
    user: User;
    loading = false;
    error = '';

    constructor(private userService: UserService,
                private router: Router,
                private route: ActivatedRoute,
                private location: Location) { }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.userService.findById(+params['id']))
            .subscribe(userFromService => this.user = userFromService);
    }

    edit() {
        this.loading = true;
        this.userService.edit(new User(this.user.name, this.user.password))
            .subscribe(result => {
                    if (result === true) {
                        this.router.navigate(['/admin/users']);
                    } else {
                        this.error = 'Error while editing';
                        this.loading = false;
                    }
                },
                error => {
                    this.error = 'Error while editing';
                    this.loading = false;
                });
    }
}