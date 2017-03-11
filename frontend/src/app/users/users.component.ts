import { Component, OnInit } from '@angular/core';
import { UserService } from './user.service';
import { User } from '../model/user';

@Component({
    selector: 'users-component',
    templateUrl: 'users.component.html',
})

export class UsersComponent implements OnInit {
    users: User[] = [];

    constructor(private userService: UserService) { }

    addItem(id: number, name: string) {
        this.userService.add(id, name);
    }

    ngOnInit() {
        this.users = this.userService.findAll();
    }
}