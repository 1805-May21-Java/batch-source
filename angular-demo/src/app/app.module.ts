import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { FirstComponent } from './components/first/first.component';
import { DatabindComponent } from './components/databind/databind.component';
import { SDirectivesComponent } from './components/s-directives/s-directives.component';
import { FavoriteComponent } from './components/favorite/favorite.component';
import { ADirectivesComponent } from './components/a-directives/a-directives.component';
import { PipesDemoComponent } from './components/pipes-demo/pipes-demo.component';


@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    DatabindComponent,
    SDirectivesComponent,
    FavoriteComponent,
    ADirectivesComponent,
    PipesDemoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
