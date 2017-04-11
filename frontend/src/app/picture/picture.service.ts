import {Injectable} from '@angular/core';
import {LogService} from '../log/log.service';
import 'rxjs/add/operator/toPromise';
import {Http, RequestOptions, Headers, Response} from "@angular/http";
import {Picture} from "../model/picture";
import {AuthenticationService} from "../authentication/authentication.service";
import {Observable} from "rxjs";
import {User} from "../model/user";
import {AuthorityComponent} from "../authority/authority.component";

@Injectable()
export class PictureService {

    constructor(private logService: LogService, private http: Http, private authenticationService: AuthenticationService) { }

    findAll(): Promise<Picture[]> {
        return this.http.get('picture/pictures')
            .toPromise()
            .then(response => response.json())
            .catch(error => {
                this.logService.write('Request failed: ' + error);
            });
    }

    findById(inputId: number): Promise<Picture> {
        return this.http.get('picture/pictures/:'+inputId)
            .toPromise()
            .then(response => response.json())
            .catch(error => {
                this.logService.write('Request failed: ' + error);
            });
    }

    findByName(inputText: string): Promise<Picture> {
        return this.http.get('picture/pictures/'+inputText)
            .toPromise()
            .then(response => response.json())
            .catch(error => {
                this.logService.write('Request failed: ' + error);
            });
    }

    delete(picture: Picture): Observable<boolean> {
        const body = JSON.stringify({id: picture.id});
        let authUser: User = AuthorityComponent.getCurrentUser();
        let options = new RequestOptions({
            headers: new Headers({
                'Content-Type': 'application/json',
                'x-auth-token': authUser.token
            })
        });
        return this.http.post('picture/delete', body, options)
            .map((response: Response) => {
                if (response.ok) {
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
