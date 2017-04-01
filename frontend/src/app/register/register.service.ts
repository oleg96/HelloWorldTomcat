import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs';
import 'rxjs/add/operator/map'

@Injectable()
export class RegisterService {

    constructor(private http: Http) { }

    register(username: string, password: string): Observable<boolean> {
        return this.http.post('register/', JSON.stringify({ username: username, password: password }))
            .map((response: Response) => {
                console.log(response);
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