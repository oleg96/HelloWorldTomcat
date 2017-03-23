import {Component, OnInit} from '@angular/core';
import {UserService} from '../user.service';
import {User} from '../../model/user';

@Component({
    selector: 'user-component',
    templateUrl: 'user.component.html',
})

export class UserComponent implements OnInit {
    users: User[];

    constructor(private userService: UserService) { }

    addItem(id: number, name: string) {
        //this.userService.add(id, name);
    }

    findAll() {
        this.userService.findAll()
            .then(usersFromService => this.users = usersFromService);
    }

    ngOnInit() {
        this.findAll();
    }
}