import { Injectable } from '@angular/core';
import { User } from '../model/user';
import { LogService } from '../log/log.service';

@Injectable()
export class UserService {
    private users: User[] = [];
    private user: User;

    constructor(private logService: LogService) { }

    findAll(): User[] {
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

    findByName(inputText: string): User {
        this.logService.write("Find user by service");
        this.users.length = 0;
        fetch('service/users/'+inputText)
            .then((responce) => responce.json())
            .then((loadedUser) => {
                for (let index = 0; index < (<any>loadedUser).length; index++) {
                    this.user = new User(loadedUser[index].id, loadedUser[index].name);
                }
            })
            .catch(error => {
                this.logService.write('Request failed: ' + error);
            });
        return this.user;
    }

    add(id: number, name: string) {
        this.users.push(new User(id, name));
        this.logService.write("Added user: "+id+" "+name);
    }
}