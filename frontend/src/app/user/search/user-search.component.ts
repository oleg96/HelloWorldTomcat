import {Component, OnInit} from '@angular/core';
import {UserService} from '../user.service';
import {User} from '../../model/user';

@Component({
    selector: 'user-search-component',
    templateUrl: 'user-search.component.html',
})

export class UserSearchComponent implements OnInit {
    user: User;
    inputText: string;

    constructor(private userService: UserService) { }

    findUserByName() {
        this.userService.findByName(this.inputText)
            .then(searchFromService => this.user = searchFromService);
    }

    ngOnInit() {
        this.findUserByName();
    }
}
