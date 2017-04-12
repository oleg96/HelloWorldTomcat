import {Component, OnInit} from '@angular/core';
import {AuthenticationGuard} from "./guard/authentication.guard";
import {AuthorityComponent} from "./authority/authority.component";
import {TranslateService} from './translate/translate.service';

@Component({
    selector: 'app',
    templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {

    public supportedLanguages: any[];

    constructor(public auth: AuthenticationGuard, public authority: AuthorityComponent, public translate: TranslateService) {
    }

    ngOnInit() {
        this.supportedLanguages = [
            { display: 'English', value: 'en' },
            { display: 'Русский', value: 'ru' },
        ];
        this.selectLang('en');
    }

    isCurrentLang(lang: string) {
        return lang === this.translate.currentLang;
    }

    selectLang(lang: string) {
        this.translate.use(lang);
    }
}