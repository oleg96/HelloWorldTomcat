import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {Location} from "@angular/common";
import {UserService} from "../user.service";
import {User} from "../../model/user";
import {Authority} from "../../model/authority";

@Component({
    selector: 'user-edit-component',
    templateUrl: 'user-edit.component.html',
})

export class UserEditComponent implements OnInit {
    availableAuthorities: Authority[];
    selectedAuthorities: Authority[];
    user: User;
    loading = false;
    error = '';

    constructor(private userService: UserService,
                private router: Router,
                private route: ActivatedRoute,
                private location: Location) {
    }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.userService.findById(+params['id']))
            .subscribe((user: User) => {
                this.user = user;
                this.selectedAuthorities = this.user.authorities;
                this.findAvailableRoles();
            });
    }

    addAuthority(authority: Authority): void {
        this.availableAuthorities.splice(this.availableAuthorities.indexOf(authority), 1);
        this.selectedAuthorities.push(authority);
    }

    removeAuthority(authority: Authority): void {
        this.selectedAuthorities.splice(this.selectedAuthorities.indexOf(authority), 1);
        this.availableAuthorities.push(authority);
    }

    findAvailableRoles() {
        this.userService.findAllRoles()
            .then(authoritiesFromService => {
                this.availableAuthorities = authoritiesFromService;
                for (var i = 0; i < this.availableAuthorities.length; i++) {
                    for (var j = 0; j < this.selectedAuthorities.length; j++) {
                        if (this.selectedAuthorities[j].name == this.availableAuthorities[i].name) {
                            this.availableAuthorities.splice(i, 1);
                        }
                    }
                }
            });
    }

    edit() {
        this.loading = true;
        this.user.authorities = this.selectedAuthorities;
        this.userService.edit(this.user)
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

    goBack(): void {
        this.location.back();
    }
}