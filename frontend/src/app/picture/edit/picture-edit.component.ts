import {Component, EventEmitter, Inject, NgZone, OnInit} from "@angular/core";
import {NgUploaderOptions, UploadedFile} from "ngx-uploader";
import {User} from "../../model/user";
import {AuthorityComponent} from "../../authority/authority.component";
import {Picture} from "../../model/picture";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {PictureService} from "../picture.service";
import {Location} from '@angular/common';

@Component({
    selector: 'picture-edit-component',
    templateUrl: 'picture-edit.component.html'
})
export class PictureEditComponent implements OnInit {
    picture: any = {};
    loading = false;
    error: string;
    options: NgUploaderOptions;
    response: any;
    sizeLimit: number = 1000000; // 1MB
    previewData: any;
    inputUploadEvents: EventEmitter<string>;
    user: User = AuthorityComponent.getCurrentUser();

    constructor(private pictureService: PictureService, private route: ActivatedRoute, private router: Router,
                private location: Location, @Inject(NgZone) private zone: NgZone) {
        this.options = new NgUploaderOptions({
            url: 'picture/edit',
            filterExtensions: true,
            allowedExtensions: ['jpg', 'png'],
            maxSize: 2097152,
            data: {},
            customHeaders: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
                'x-auth-token': this.user.token
            },
            autoUpload: false,
            plainJson: true,
            fieldName: 'file',
            fieldReset: true,
            maxUploads: 2,
            method: 'POST',
            previewUrl: true,
            withCredentials: false
        });

        this.inputUploadEvents = new EventEmitter<string>();
    }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.pictureService.findById(+params['id']))
            .subscribe((picture: Picture) => {
                this.picture = picture;
                this.previewData = this.picture.image;
            });
    }

    goBack(): void {
        this.location.back();
    }

    startUpload() {
        this.loading = true;
        this.options['data']['id'] = this.picture.id;
        this.options['data']['author'] = this.picture.author;
        this.options['data']['name'] = this.picture.name;
        this.options['data']['description'] = this.picture.description;
        this.options['data']['owner'] = this.picture.owner;
        this.options['data']['tags'] = this.picture.tags;
        this.options['data']['image'] = this.previewData;
        this.inputUploadEvents.emit('startUpload');
    }

    beforeUpload(uploadingFile: UploadedFile): void {
        if (uploadingFile.size > this.sizeLimit) {
            uploadingFile.setAbort();
            this.error = 'File is too large!';
        }
    }

    handleUpload(data: any): void {
        this.zone.run(() => {
            this.response = data;
            this.loading = false;
        });
    }

    handlePreviewData(data: any) {
        this.previewData = data;
    }

    delete() {
        this.loading = true;
        if (this.picture.id > 0) {
            this.pictureService.delete(this.picture)
                .subscribe(result => {
                        if (result === true) {
                            this.router.navigate(['/pictures/all']);
                        } else {
                            this.error = 'Error while deleting';
                            this.loading = false;
                        }
                    },
                    error => {
                        this.error = 'Error while deleting';
                        this.loading = false;
                    });
        }
    }
}