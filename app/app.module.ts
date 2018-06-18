import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HighlightcomponentComponent } from './highlightcomponent/highlightcomponent.component';
import { ProfilecomponentComponent } from './profilecomponent/profilecomponent.component';
import { SelectcomponentComponent } from './selectcomponent/selectcomponent.component';
import { TablecomponentComponent } from './tablecomponent/tablecomponent.component';
import { UsercomponentComponent } from './usercomponent/usercomponent.component';
import { NavcomponentComponent } from './navcomponent/navcomponent.component';
import { appRoutes } from './routes';

@NgModule({
  declarations: [
    AppComponent,
    HighlightcomponentComponent,
    ProfilecomponentComponent,
    SelectcomponentComponent,
    TablecomponentComponent,
    UsercomponentComponent,
    NavcomponentComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
