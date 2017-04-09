import {Injectable} from "@angular/core";
import {User} from "../model/user";
import {LogService} from "../log/log.service";
import "rxjs/add/operator/toPromise";
import {Headers, Http, RequestOptions, Response} from "@angular/http";
import {AuthorityComponent} from "../authority/authority.component";
import {Observable} from "rxjs";
import {Authority} from "../model/authority";

@Injectable()
export class UserService {

    constructor(private logService: LogService, private http: Http) {
    }

    findAllRoles(): Promise<Authority[]> {
        let authUser: User = AuthorityComponent.getCurrentUser();
        let options = new RequestOptions({
            headers: new Headers({
                'Content-Type': 'application/json',
                'x-auth-token': authUser.token
            })
        });
        return this.http.get('authority/authorities', options)
            .toPromise()
            .then(response => response.json())
            .catch(error => {
                this.logService.write('Request failed: ' + error);
            });
    }

    findAll(): Promise<User[]> {
        let authUser: User = AuthorityComponent.getCurrentUser();
        let options = new RequestOptions({
            headers: new Headers({
                'Content-Type': 'application/json',
                'x-auth-token': authUser.token
            })
        });
        return this.http.get('user/users', options)
            .toPromise()
            .then(response => response.json())
            .catch(error => {
                this.logService.write('Request failed: ' + error);
            });
    }

    findByName(inputText: string): Promise<User> {
        let authUser: User = AuthorityComponent.getCurrentUser();
        let options = new RequestOptions({
            headers: new Headers({
                'Content-Type': 'application/json',
                'x-auth-token': authUser.token
            })
        });
        return this.http.get('user/users/' + inputText)
            .toPromise()
            .then(response => response.json())
            .catch(error => {
                this.logService.write('Request failed: ' + error);
            });
    }

    findById(inputId: number): Promise<User> {
        let authUser: User = AuthorityComponent.getCurrentUser();
        let options = new RequestOptions({
            headers: new Headers({
                'Content-Type': 'application/json',
                'x-auth-token': authUser.token
            })
        });
        return this.http.get('user/users/:' + inputId)
            .toPromise()
            .then(response => response.json())
            .catch(error => {
                this.logService.write('Request failed: ' + error);
            });
    }

    edit(user: User): Observable<boolean> {
        const body = JSON.stringify({name: user.name, password: user.password});
        const options = new RequestOptions({headers: new Headers({'Content-Type': 'application/json'})});
        return this.http.post('user/edit', body, options)
            .map((response: Response) => {
                let result = response.ok;
                if (result) {
                    console.log(result);
                    return true;
                }
                console.log(result);
                return false;
            })
            .catch(this.handleServerError);
    }

    private handleServerError(error: Response) {
        return Observable.throw(error.json());
    }
}