import {Injectable} from "@angular/core";
import {Headers, Http, RequestOptions, Response} from "@angular/http";
import {Observable} from "rxjs";
import "rxjs/add/operator/map";
import {User} from "../model/user";

@Injectable()
export class AuthenticationService {

    constructor(private http: Http) {
    }

    login(user: User): Observable<boolean> {
        const body = JSON.stringify({name: user.name, password: user.password});
        const options = new RequestOptions({headers: new Headers({'Content-Type': 'application/json'})});
        return this.http.post('auth/login', body, options)
            .map((response: Response) => {
                let token = response.json().token;
                let user = response.json().user;
                if (token && user) {
                    user.token = token;
                    localStorage.setItem('currentUser', JSON.stringify(user));
                    return true;
                }
                return false;
            })
            .catch(this.handleServerError);
    }

    private handleServerError(error: Response) {
        return Observable.throw(error.json());
    }

    logout(): void {
        localStorage.removeItem('currentUser');
    }
}