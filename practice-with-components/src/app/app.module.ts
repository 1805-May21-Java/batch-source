import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HighlightComponentComponent } from './highlight-component/highlight-component.component';
import { ProfileComponent } from './profile/profile.component';
import { SelectComponent } from './select/select.component';
import { TableComponent } from './table/table.component';
import { UserComponent } from './user/user.component';
import { ConfigService } from './config.service';
import { NavComponent } from './nav/nav.component';
import { appRoutes } from './routes';

@NgModule({
  declarations: [
    AppComponent,
    HighlightComponentComponent,
    ProfileComponent,
    SelectComponent,
    TableComponent,
    UserComponent,
    NavComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [ConfigService],
  bootstrap: [AppComponent]
})
export class AppModule { }
