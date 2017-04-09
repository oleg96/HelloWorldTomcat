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
    availableAuthorities: Authority[] = [];
    selectedAuthorities: Authority[] = [];
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
                this.findAllRoles();
                this.selectedAuthorities = this.user.authorities;
                this.selectedAuthorities.forEach(function(val){
                    var foundIndex = this.availableAuthorities.indexOf(val);
                    if(foundIndex != -1){
                        this.availableAuthorities.splice(foundIndex, 1);
                    }
                });
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

    findAllRoles() {
        this.userService.findAllRoles()
            .then(userFromService => this.availableAuthorities = userFromService);
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

    goBack(): void {
        this.location.back();
    }
}