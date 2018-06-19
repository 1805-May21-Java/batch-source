import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule} from '@angular/router'

import { AppComponent } from './app.component';
import { HighlightComponent } from './components/highlight/highlight.component';
import { ProfileComponent } from './components/profile/profile.component';
import { SelectComponent } from './components/select/select.component';
import { TableComponent } from './components/table/table.component';
import { UserComponent } from './components/user/user.component';
import { NavComponent } from './components/nav/nav.component';
import { HttpClientModule } from '@angular/common/http';
import { UserService } from './user.service';

@NgModule({
  declarations: [
    AppComponent,
    HighlightComponent,
    ProfileComponent,
    SelectComponent,
    TableComponent,
    UserComponent,
    NavComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', redirectTo: 'home', pathMatch: 'full' },
      { path: 'highlight', component: HighlightComponent },
      { path: 'profile', component: ProfileComponent },
      { path: 'select', component: SelectComponent },
      { path: 'user', component: UserComponent },
      { path: 'table', component: TableComponent },
      { path: '*', redirectTo: 'home' }
])
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
