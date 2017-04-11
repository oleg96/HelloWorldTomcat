import {Component, OnInit} from "@angular/core";
import {Picture} from "../../model/picture";
import {PictureService} from "../picture.service";
import {Router} from "@angular/router";
import {AuthenticationGuard} from "../../guard/authentication.guard";
import {AuthorityComponent} from "../../authority/authority.component";

@Component({
    selector: 'picture-all-component',
    templateUrl: 'picture-all.component.html',
})

export class PictureAllComponent implements OnInit {
    pictures: Picture[];

    constructor(
        private router: Router,
        private pictureService: PictureService,
        public auth: AuthenticationGuard,
        public authority: AuthorityComponent) { }

    findAll() {
        this.pictureService.findAll()
            .then(picturesFromService => this.pictures = picturesFromService);
    }

    ngOnInit() {
        this.findAll();
    }
}