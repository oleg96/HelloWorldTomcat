import {Injectable} from '@angular/core';
import {User} from '../model/user';
import {LogService} from '../log/log.service';
import 'rxjs/add/operator/toPromise';
import {Http, Headers, RequestOptions} from "@angular/http";
import {AuthenticationService} from "../authentication/authentication.service";

@Injectable()
export class UserService {

    constructor(private logService: LogService, private http: Http, private authenticationService: AuthenticationService) { }

    findAll(): Promise<User[]> {
        // add authorization header with jwt token
        let headers = new Headers({'Content-Type': 'application/json', 'x-auth-token': this.authenticationService.token});
        let options = new RequestOptions({headers: headers});
        
        return this.http.get('user/users', options)
            .toPromise()
            .then(response => response.json())
            .catch(error => {
                this.logService.write('Request failed: ' + error);
            });
    }

    findByName(inputText: string): Promise<User> {
        return this.http.get('user/users/'+inputText)
            .toPromise()
            .then(response => response.json())
            .catch(error => {
                this.logService.write('Request failed: ' + error);
            });
    }
}