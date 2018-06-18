import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TextComponent } from './components/text/text.component';
import { NavComponent } from './components/nav/nav.component';
import { RoutingModule } from './routing.module';
import { ProfileDisplayComponent } from './components/profile-display/profile-display.component';
import { SelectComponentComponent } from './select-component/select-component.component';
import { TableComponent } from './components/table/table.component';
import { PageToPopulateComponent } from './components/page-to-populate/page-to-populate.component';
import { WebServiceService } from './services/web-service.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    TextComponent,
    NavComponent,
    ProfileDisplayComponent,
    SelectComponentComponent,
    TableComponent,
    PageToPopulateComponent
  ],
  imports: [
    BrowserModule,
   RoutingModule,
   HttpClientModule
  ],
  providers: [WebServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
