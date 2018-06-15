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
import { ConvertToSpacesPipe } from './pipes/convert-to-spaces.pipe';
import { ClickerComponent } from './components/clicker/clicker.component';


@NgModule({
  declarations: [ //registering our components and pipes
    AppComponent,
    FirstComponent,
    DatabindComponent,
    SDirectivesComponent,
    FavoriteComponent,
    ADirectivesComponent,
    PipesDemoComponent,
    ConvertToSpacesPipe,
    ClickerComponent
  ],
  imports: [ //including any outside modules
    BrowserModule,
    FormsModule
  ],
  providers: [ //registering our services

  ],
  bootstrap: [AppComponent] //starting component for our application
})
export class AppModule { }
