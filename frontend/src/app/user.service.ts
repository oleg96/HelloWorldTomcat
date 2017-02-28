import { Injectable } from '@angular/core';
import { User } from './user';
import { LogService } from './log.service';

@Injectable()
export class UserService {
    private users: User[] = [];

    constructor(private logService: LogService) { }

    getUsers(): User[] {
        this.logService.write("Get users from service");
        this.users.length = 0;
        fetch('service/users')
            .then((responce) => responce.json())
            .then((loadedUsers) => {
                for (let index = 0; index < (<any>loadedUsers).length; index++) {
                    this.users.push(new User(loadedUsers[index].id, loadedUsers[index].name));
                }
            })
            .catch(error => {
                this.logService.write('Request failed: ' + error);
            });
        return this.users;
    }

    addUser(id: number, name: string) {
        this.users.push(new User(id, name));
        this.logService.write("Added user: "+id+" "+name);
    }
}