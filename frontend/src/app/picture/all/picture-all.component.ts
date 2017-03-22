import {Component, OnInit} from '@angular/core';
import {Picture} from "../../model/picture";
import {PictureService} from "../picture.service";

@Component({
    selector: 'picture-all-component',
    templateUrl: 'picture-all.component.html',
})

export class PictureAllComponent implements OnInit {
    pictures: Picture[];

    constructor(private pictureService: PictureService) { }

    findAll() {
        this.pictureService.findAll()
            .then(picturesFromService => this.pictures = picturesFromService);
    }

    ngOnInit() {
        this.findAll();
    }
}