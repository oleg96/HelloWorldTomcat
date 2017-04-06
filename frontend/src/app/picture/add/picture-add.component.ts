import {Component, ViewChild} from "@angular/core";
import {PictureService} from "../picture.service";

@Component({
    selector: 'picture-add-component',
    templateUrl: 'picture-add.component.html',
})

export class PictureAddComponent {

    @ViewChild("fileInput") fileInput;

    constructor(
        private pictureService: PictureService) { }

    add(): void {
        let fi = this.fileInput.nativeElement;
        if (fi.files && fi.files[0]) {
            let fileToUpload = fi.files[0];
            this.pictureService
                .add(fileToUpload)
                .subscribe(res => {
                    console.log(res);
                });
        }
    }
}