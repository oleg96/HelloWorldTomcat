import {Component, EventEmitter, Inject, NgZone} from "@angular/core";
import {NgUploaderOptions, UploadedFile} from "ngx-uploader";
import {User} from "../../model/user";
import {AuthorityComponent} from "../../authority/authority.component";

@Component({
    selector: 'picture-add-component',
    templateUrl: 'picture-add.component.html'
})
export class PictureAddComponent {
    picture: any = {};
    loading = false;
    error: string;
    options: NgUploaderOptions;
    response: any;
    sizeLimit: number = 1000000; // 1MB
    previewData: any;
    inputUploadEvents: EventEmitter<string>;
    user: User = AuthorityComponent.getCurrentUser();

    constructor(@Inject(NgZone) private zone: NgZone) {
        this.options = new NgUploaderOptions({
            url: 'picture/add',
            filterExtensions: true,
            allowedExtensions: ['jpg', 'png'],
            maxSize: 2097152,
            data: {},
            customHeaders: {
                'Content-Type':'application/json',
                'Accept':'application/json',
                'x-auth-token':this.user.token
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

    startUpload() {
        this.loading = true;
        this.options['data']['author'] = this.picture.author;
        this.options['data']['name'] = this.picture.name;
        this.options['data']['description'] = this.picture.description;
        this.options['data']['owner'] = "Oleg";
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
}