import { Component, OnInit } from '@angular/core';
import { UserService } from './user.service';
import { User } from './user';
import { LogService } from "./log.service";

@Component({
    selector: 'user-component',
    templateUrl: './user.component.html',
    providers: [ UserService, LogService ]
})

export class UserComponent implements OnInit {
    users: User[] = [];

    constructor(private userService: UserService) { }

    addItem(id: number, name: string) {
        this.userService.addUser(id, name);
    }

    ngOnInit() {
        this.users = this.userService.getUsers();
    }
}