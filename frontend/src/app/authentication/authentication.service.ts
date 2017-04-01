import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs';
import 'rxjs/add/operator/map'

@Injectable()
export class AuthenticationService {
    public token: string;

    constructor(private http: Http) {
        var currentUser = JSON.parse(localStorage.getItem('currentUser'));
        this.token = currentUser && currentUser.token;
    }

    login(username: string, password: string): Observable<boolean> {
        return this.http.post('auth/login', JSON.stringify({ username: username, password: password }))
            .map((response: Response) => {
                let token = response.json() && response.json().token;
                if (token) {
                    this.token = token;
                    localStorage.setItem('currentUser', JSON.stringify({ username: username, token: token }));
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
        this.token = null;
        localStorage.removeItem('currentUser');
    }
}