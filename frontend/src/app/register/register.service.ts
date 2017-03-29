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
                let result = response.json() && response.json().result;
                if (result) {
                    return true;
                }
                return false;
            });
    }
}