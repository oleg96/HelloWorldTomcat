import {Injectable} from '@angular/core';
import {LogService} from '../log/log.service';
import 'rxjs/add/operator/toPromise';
import {Http} from "@angular/http";
import {Picture} from "../model/picture";
import {AuthenticationService} from "../authentication/authentication.service";

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
}
