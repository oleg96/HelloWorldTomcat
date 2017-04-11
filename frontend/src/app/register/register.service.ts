import {Injectable} from '@angular/core';
import {Http, Response, RequestOptions, Headers} from '@angular/http';
import {Observable} from 'rxjs';
import 'rxjs/add/operator/map'
import {User} from "../model/user";

@Injectable()
export class RegisterService {

    constructor(private http: Http) { }

    register(user: User): Observable<boolean> {
        const body = JSON.stringify({name: user.name, password: user.password});
        const options = new RequestOptions({headers: new Headers({'Content-Type': 'application/json'})});
        return this.http.post('user/register/', body, options)
            .map((response: Response) => {
                let result = response.ok;
                if (result) {
                    return true;
                }
                return false;
            })
            .catch(this.handleServerError);
    }

    private handleServerError(error: Response) {
        return Observable.throw(error.json());
    }
}