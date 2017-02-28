import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { BrowserModule} from '@angular/platform-browser';
import { UserComponent } from './user.component';

@NgModule({
    imports: [ BrowserModule, FormsModule ],
    declarations: [ UserComponent ],
    bootstrap: [ UserComponent ]
})

export class AppModule { }