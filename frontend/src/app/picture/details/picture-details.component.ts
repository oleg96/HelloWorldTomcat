import {Component, OnInit} from '@angular/core';
import {Picture} from "../../model/picture";
import {PictureService} from "../picture.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from '@angular/common';

@Component({
    selector: 'picture-details-component',
    templateUrl: 'picture-details.component.html',
})

export class PictureComponent implements OnInit {
    picture: Picture;

    constructor(private pictureService: PictureService,
                private route: ActivatedRoute,
                private location: Location) { }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.pictureService.findById(+params['id']))
            .subscribe(pictureFromService => this.picture = pictureFromService);
    }

    goBack(): void {
        this.location.back();
    }
}