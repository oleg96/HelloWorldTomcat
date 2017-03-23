import {Pipe, PipeTransform} from "@angular/core";
import {DomSanitizer} from "@angular/platform-browser";

@Pipe({
    name: 'secureUrl'
})
export class SecureUrlPipe implements PipeTransform {
    constructor(private sanitizer: DomSanitizer){ }

    transform(url: string) {
        var myUrl= this.sanitizer.bypassSecurityTrustUrl(url);
        return myUrl;
    }
}
