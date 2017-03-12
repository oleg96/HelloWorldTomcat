import { Injectable } from '@angular/core';
import { User } from '../model/user';
import { LogService } from '../log/log.service';
import 'rxjs/add/operator/toPromise';
import { Http } from "@angular/http";

@Injectable()
export class UserService {
    private users: User[];

    constructor(private logService: LogService, private http: Http) { }

    findAll(): Promise<User[]> {
        return this.http.get('service/users')
            .toPromise()
            .then(response => response.json())
            .catch(error => {
                this.logService.write('Request failed: ' + error);
            });
    }

    findByName(inputText: string): Promise<User> {
        return this.http.get('service/users/'+inputText)
            .toPromise()
            .then(response => response.json())
            .catch(error => {
                this.logService.write('Request failed: ' + error);
            });
    }

    add(id: number, name: string) {
        this.users.push(new User(id, name));
        this.logService.write("Added user: "+id+" "+name);
    }
}